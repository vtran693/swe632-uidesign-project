package cs.swe632.smartclassregistration.springboot.dao;

import cs.swe632.smartclassregistration.springboot.model.Course;

/**
 * Created with IntelliJ IDEA.
 * User: viettran
 * Date: 11/13/17
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CourseDAO {

    List<Course> getAllCourses();
    Course getCourseById(int courseId);
    Course getCourseByName(String courseName);
    Course getCourseByNameAndSection(String courseName, String courseSection);
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(String courseName, String courseSection);
    boolean courseExists(String courseName, String courseSection);
    boolean isFull(Course course);

}
