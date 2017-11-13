package cs.swe632.smartclassregistration.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cs.swe632.smartclassregistration.springboot.model.Course;
import cs.swe632.smartclassregistration.springboot.model.Student;

@Transactional
@Repository
public class StudentDAOImpl implements StudentDAO{
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
		String hql = "SELECT student FROM TABLE Students where student.username = :username";
		int count = entityManager.createQuery(hql).setParameter("username", studentUsername)
					.getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public List<Course> getStudentCompletedCourses(String studentUsername) {
		String hql = "SELECT student FROM TABLE Students where student.username = :username";
		Student student = (Student) entityManager.createQuery(hql).setParameter("username", studentUsername).getSingleResult();
		return student.getStudentCompletedCourses();
	}

	@Override
	public List<Course> getStudentCurrentRegisteredCourses(String studentUsername) {
		String hql = "SELECT student FROM TABLE Students where student.username = :username";
		Student student = (Student) entityManager.createQuery(hql).setParameter("username", studentUsername).getSingleResult();
		return student.getStudentCurrentRegisteredCourses();
	}

}
