package cs.swe632.smartclassregistration.springboot.service;

/**
 * Created with IntelliJ IDEA.
 * User: viettran
 * Date: 11/13/17
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CourseService {

    List<Course> getAllCourses();
    Student getCourseByName(String courseName);
    Student getCourseByNameAndSection(String courseName, String courseSection);
    boolean addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(String courseName);

}
