package cs.swe632.smartclassregistration.springboot.dao;

import cs.swe632.smartclassregistration.springboot.model.Course;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: viettran
 * Date: 11/13/17
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@Repository
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllUndergradCourses() {
		String hql = "from Course crs where crs.courseLevel = :level ORDER BY crs.courseName";
		return (List<Course>) entityManager.createQuery(hql).setParameter("level", "Undergrad").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllUndergradCoursesSwe() {
		String hql = "from Course crs where crs.courseLevel = :level and crs.courseMajor = :major ORDER BY crs.courseName";
		return (List<Course>) entityManager.createQuery(hql).setParameter("level", "Undergrad").setParameter("major", "SWE").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllUndergradCoursesCs() {
		String hql = "from Course crs where crs.courseLevel = :level and crs.courseMajor = :major ORDER BY crs.courseName";
		return (List<Course>) entityManager.createQuery(hql).setParameter("level", "Undergrad").setParameter("major", "CS").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllGradCourses() {
		String hql = "from Course crs where crs.courseLevel = :level ORDER BY crs.courseName";
		return (List<Course>) entityManager.createQuery(hql).setParameter("level", "Grad").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllGradCoursesSwe() {
		String hql = "from Course crs where crs.courseLevel = :level and crs.courseMajor = :major ORDER BY crs.courseName";
		return (List<Course>) entityManager.createQuery(hql).setParameter("level", "Grad").setParameter("major", "SWE").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllGradCoursesCs() {
		String hql = "from Course crs where crs.courseLevel = :level and crs.courseMajor = :major ORDER BY crs.courseName";
		return (List<Course>) entityManager.createQuery(hql).setParameter("level", "Grad").setParameter("major", "CS").getResultList();
	}

}
