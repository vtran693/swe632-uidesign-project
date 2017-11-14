package cs.swe632.smartclassregistration.springboot.dao;

import java.util.List;

import cs.swe632.smartclassregistration.springboot.model.Course;
import cs.swe632.smartclassregistration.springboot.model.Student;

public interface StudentDAO {
    List<Student> getAllStudents();
    Student getStudentByUsername(String studentUsername);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(String studentUsername); 
	boolean studentExists(String studentUsername);
	
	String registerCourse(String studentUsername, Course course);
	String dropCourse(String studentUsername, Course course);
	
	// Real DAO action for front end needs
	List<Course> getStudentCompletedCourses(String studentUsername);
	List<Course> getStudentCurrentRegisteredCourses(String studentUsername);
	
}
