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

    String registerCourse(String studentUsername, Course course);
    String dropCourse(String studentUsername, Course course);

	// Real logic for front end needs
	List<Course> getStudentCompletedCourses(String studentUsername);
	List<Course> getStudentCurrentRegisteredCourses(String studentUsername);
	void setStudentCompletedCourses(String studentUsername, Course completedCourse);
	void setStudentCurrentRegisteredCourses(String studentUsername, Course registeredCourse);
}
