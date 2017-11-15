package cs.swe632.smartclassregistration.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.swe632.smartclassregistration.springboot.dao.CourseDAO;
import cs.swe632.smartclassregistration.springboot.model.Course;

/**
 * Created with IntelliJ IDEA.
 * User: viettran
 * Date: 11/13/17
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDAO courseDAO;
	
	@Override
	public List<Course> getCourseByName(String courseName) {
		List<Course> obj = courseDAO.getCourseByName(courseName);
		return obj;
	}	
	
	@Override
	public Course getCourseByNameAndSection(String courseName, String courseSection) {
		Course obj = courseDAO.getCourseByNameAndSection(courseName, courseSection);
		return obj;
	}
	
	@Override
	public List<Course> getAllCourses(){
		return courseDAO.getAllCourses();
	}
	@Override
	public synchronized boolean addCourse(Course course){
		if (courseDAO.courseExists(course.getCourseName(), course.getCourseSection())) {
			return false;
		} else {
			courseDAO.addCourse(course);
			return true;
		}
	}
	@Override
	public void updateCourse(Course course) {
		courseDAO.updateCourse(course);
	}
	@Override
	public void deleteCourse(String courseName, String courseSection) {
		courseDAO.deleteCourse(courseName, courseSection);
	}

	@Override
	public List<Course> getAllUndergradCourses() {
		return courseDAO.getAllUndergradCourses();
	}

	@Override
	public List<Course> getAllUndergradCoursesSwe() {
		return courseDAO.getAllUndergradCoursesSwe();
	}

	@Override
	public List<Course> getAllUndergradCoursesCs() {
		return courseDAO.getAllUndergradCoursesCs();
	}


	@Override
	public List<Course> getAllGradCourses() {
		return courseDAO.getAllGradCourses();
	}

	@Override
	public List<Course> getAllGradCoursesSwe() {
		return courseDAO.getAllGradCoursesSwe();
	}

	@Override
	public List<Course> getAllGradCoursesCs() {
		return courseDAO.getAllGradCoursesCs();
	}


}
