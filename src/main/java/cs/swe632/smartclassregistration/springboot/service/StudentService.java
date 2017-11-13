package cs.swe632.smartclassregistration.springboot.service;

import java.util.List;

import cs.swe632.smartclassregistration.springboot.model.Course;
import cs.swe632.smartclassregistration.springboot.model.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentByUsername(String studentUsername);
    boolean addStudent(Student student);
    void updateStudent(Student student);
	void deleteStudent(String studentUsername);
	
	// Real logic for front end needs
	List<Course> getStudentCompletedCourses(String studentUsername);
	List<Course> getStudentCurrentRegisteredCourses(String studentUsername);
}
