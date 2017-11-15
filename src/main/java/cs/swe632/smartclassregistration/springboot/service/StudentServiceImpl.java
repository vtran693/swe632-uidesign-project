package cs.swe632.smartclassregistration.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.swe632.smartclassregistration.springboot.dao.StudentDAO;
import cs.swe632.smartclassregistration.springboot.model.Course;
import cs.swe632.smartclassregistration.springboot.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public Student getStudentByUsername(String studentUsername) {
		Student obj = studentDAO.getStudentByUsername(studentUsername);
		return obj;
	}	
	
	@Override
	public List<Student> getAllStudents(){
		return studentDAO.getAllStudents();
	}
	@Override
	public synchronized boolean addStudent(Student student){
		if (studentDAO.studentExists(student.getStudentUsername())) {
			return false;
		} else {
			studentDAO.addStudent(student);
			return true;
		}
	}
	@Override
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
	}
	@Override
	public void deleteStudent(String studentUsername) {
		studentDAO.deleteStudent(studentUsername);
	}

	// Real service for front end needs
	
	@Override
	public List<Course> getStudentCompletedCourses(String studentUsername) {
		List<Course> completedCourses = studentDAO.getStudentCompletedCourses(studentUsername);
		return completedCourses;
	}

	@Override
	public List<Course> getStudentCurrentRegisteredCourses(String studentUsername) {
		List<Course> currentRegisteredCourses = studentDAO.getStudentCurrentRegisteredCourses(studentUsername);
		return currentRegisteredCourses;
	}

	@Override
	public String registerCourse(String studentUsername, Course course) {
		return studentDAO.registerCourse(studentUsername, course);
	}

	@Override
	public String dropCourse(String studentUsername, Course course) {
		return studentDAO.dropCourse(studentUsername, course);
		
	}

	@Override
	public void setStudentCompletedCourses(String studentUsername, Course completedCourse) {
		// TODO Auto-generated method stub
		studentDAO.setStudentCompletedCourses(studentUsername, completedCourse);
	
	}

}
