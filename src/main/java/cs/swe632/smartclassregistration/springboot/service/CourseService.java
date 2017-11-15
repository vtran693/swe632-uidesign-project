package cs.swe632.smartclassregistration.springboot.service;

import java.util.List;

import cs.swe632.smartclassregistration.springboot.model.Course;

/**
 * Created with IntelliJ IDEA.
 * User: viettran
 * Date: 11/13/17
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CourseService {

    List<Course> getAllCourses();
    List<Course> getCourseByName(String courseName);
    Course getCourseByNameAndSection(String courseName, String courseSection);
    boolean addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(String courseName, String courseSection);
	List<Course> getAllUndergradCourses();
	List<Course> getAllUndergradCoursesSwe();
	List<Course> getAllUndergradCoursesCs();
	List<Course> getAllGradCourses();
	List<Course> getAllGradCoursesSwe();
	List<Course> getAllGradCoursesCs();

}
