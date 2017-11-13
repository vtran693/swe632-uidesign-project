package cs.swe632.smartclassregistration.springboot.dao;

import cs.swe632.smartclassregistration.springboot.model.Course;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: viettran
 * Date: 11/13/17
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class CourseDAOImpl implements CourseDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Course getCourseById(int courseId) {
        Course course = entityManager.find(Course.class, courseId);
        return course;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Course> getCourseByName(String courseName) {
        String hql = "from Course where courseName = :name ORDER BY courseSection";
        List<Course> courseList = (List<Course>) entityManager.createQuery(hql).setParameter("name", courseName)
                .getResultList();
        return courseList;
    }

    @Override
    public Course getCourseByNameAndSection(String courseName, String courseSection) {
        String hql = "from Course where courseName = :name and courseSection = :section";
        Course course = (Course) entityManager.createQuery(hql).setParameter("name", courseName).setParameter("section", courseSection)
                .getSingleResult();
        return course;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Course> getAllCourses() {
        String hql = "FROM Course as crs ORDER BY crs.courseName";
        return (List<Course>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addCourse(Course course) {
        entityManager.persist(course);
    }
    @Override
    public void updateCourse(Course course) {
        Course specificCourse = this.getCourseByNameAndSection(course.getCourseName(), course.getCourseSection());
        specificCourse.setCourseAvailability(course.getCourseAvailability());
        entityManager.flush();
    }
    @Override
    public void deleteCourse(String courseName, String courseSection) {
        entityManager.remove(this.getCourseByNameAndSection(courseName, courseSection));
    }
    @Override
    public boolean courseExists(String courseName, String courseSection) {
        //String hql = "FROM Course as course WHERE course.title = ? and course.category = ?";
        String hql = "from Course where courseName = :name and courseSection = :section";
        int count = entityManager.createQuery(hql).setParameter("name", courseName).setParameter("section", courseSection)
                .getResultList().size();
        return count > 0 ? true : false;
    }
    @Override
    public boolean isFull(Course course){
        return (course.getCourseAvailability() > 0 );

    }

}
