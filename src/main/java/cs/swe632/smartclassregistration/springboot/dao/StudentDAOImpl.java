package cs.swe632.smartclassregistration.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cs.swe632.smartclassregistration.springboot.model.Course;
import cs.swe632.smartclassregistration.springboot.model.Student;

@Transactional
@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@Autowired
	CourseDAO courseDAO;
	
	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public Student getStudentByUsername(String studentUsername) {
		Student student = entityManager.find(Student.class, studentUsername);
		return student;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		String hql = "FROM Student as stdt ORDER BY stdt.studentUsername";
		return (List<Student>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addStudent(Student student) {
		entityManager.persist(student);
	}
	@Override
	public void updateStudent(Student student) {
		Student specificStudent = this.getStudentByUsername(student.getStudentUsername());
		// Only need to update the current registration course list
		specificStudent.setStudentCurrentRegisteredCourses(student.getStudentCurrentRegisteredCourses());

		entityManager.flush();
	}
	@Override
	public void deleteStudent(String studentUsername) {
		entityManager.remove(this.getStudentByUsername(studentUsername));
	}
	@Override
	public boolean studentExists(String studentUsername) {
		//String hql = "FROM Student as student WHERE student.title = ? and student.category = ?";
		String hql = "from Student where studentUsername = :username";
		int count = entityManager.createQuery(hql).setParameter("username", studentUsername)
					.getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public List<Course> getStudentCompletedCourses(String studentUsername) {
		String hql = "from Student where studentUsername = :username";
		Student student = (Student) entityManager.createQuery(hql).setParameter("username", studentUsername).getSingleResult();
		return student.getStudentCompletedCourses();
	}

	@Override
	public void setStudentCompletedCourses(String studentUsername, Course completedCourse) {
		Student specificStudent = this.getStudentByUsername(studentUsername);
		specificStudent.getStudentCompletedCourses().add(completedCourse);
		specificStudent.setStudentCompletedCourses(specificStudent.getStudentCompletedCourses());
		entityManager.flush();
	}

	
	@Override
	public List<Course> getStudentCurrentRegisteredCourses(String studentUsername) {
		String hql = "from Student where studentUsername = :username";
		Student student = (Student) entityManager.createQuery(hql).setParameter("username", studentUsername).getSingleResult();
		return student.getStudentCurrentRegisteredCourses();
	}

	@Override
	public String registerCourse(String studentUsername, Course course) {
		
		if (this.isTaken(studentUsername, course)) {
			return "taken";
		}
		String conflictedCourse = this.hasTimeConflictWith(studentUsername, course);
		
		if (!conflictedCourse.isEmpty()){
			return "conflict with " + conflictedCourse;
		}
		else {
			Course specificCourse = courseDAO.getCourseByNameAndSection(course.getCourseName(), course.getCourseSection());
			// Decrement the availability of the course
			// If return false, it means the class is full
			if (!specificCourse.decrementAvailability()) {
				return "class is full";
			}
			else {
				// Add the course into the current
				this.getStudentCurrentRegisteredCourses(studentUsername).add(specificCourse);
				// Flush the value update
				entityManager.flush();
				return "success";
			}
			
			
		}
	}
	
	private boolean isTaken(String studentUsername, Course course) {
		List<Course> completedCourseList = this.getStudentCompletedCourses(studentUsername);
		for (Course eachCompletedCourse : completedCourseList) {
			if (eachCompletedCourse.getCourseName().equals(course.getCourseName())) {
				return true;
			}
		}
		return false;
	}
	
	private String hasTimeConflictWith(String studentUsername, Course course) {
		List<Course> currentRegisteredCourseList = this.getStudentCurrentRegisteredCourses(studentUsername);
		for (Course eachRegisteredCourse : currentRegisteredCourseList) {
			if (eachRegisteredCourse.getCourseDate().equals(course.getCourseDate()) 
					&& eachRegisteredCourse.getCourseTimePeriod().equals(course.getCourseTimePeriod())) {
				return ( eachRegisteredCourse.getCourseName() + " - " + eachRegisteredCourse.getCourseSection() );
			}
		}
		return "";
	}

	@Override
	public String dropCourse(String studentUsername, Course course) {
		
		Course specificCourse =  courseDAO.getCourseByNameAndSection(course.getCourseName(), course.getCourseSection());
		// Update the availability back to the course
		boolean success = specificCourse.incrementAvailability();
		if (!success) {
			return "error";
		}
		else {
			List<Course> currentRegisteredCourseList = this.getStudentCurrentRegisteredCourses(studentUsername);
			currentRegisteredCourseList.remove(course);
			// Flush the update
			entityManager.flush();
			return "success";
		}
	}
	
}
