package cs.swe632.smartclassregistration.springboot.model;
import java.io.Serializable;

import javax.persistence.*;


@Embeddable
public class Course implements Serializable{
	
	// Primary Key (Course Name, Course Section ID)
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="course_name")
	private String courseName;
	@Id
	@Column(name="course_section")
	private String courseSection;
	
	@Column(name="course_date")
	private String courseDate;
	
	@Column(name="course_timeperiod")
	private String courseTimePeriod;
	
	@Column(name="course_availability")
	private int courseAvailability;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseSection() {
		return courseSection;
	}
	public void setCourseSection(String courseSection) {
		this.courseSection = courseSection;
	}
	public String getCourseDate() {
		return courseDate;
	}
	public void setCourseDate(String courseDate) {
		this.courseDate = courseDate;
	}
	public String getCourseTimePeriod() {
		return courseTimePeriod;
	}
	public void setCourseTimePeriod(String courseTimePeriod) {
		this.courseTimePeriod = courseTimePeriod;
	}
	public int getCourseAvailability() {
		return courseAvailability;
	}
	public void setCourseAvailability(int courseAvailability) {
		this.courseAvailability = courseAvailability;
	}
	
	// Custom method to decrement availability (when someone registers for the course)
	public void decrementAvailability() {
		this.courseAvailability--;
	}
	
	// Custom method to increment availability (when someone drops the course registration)
	public void incrementAvailability() {
		this.courseAvailability++;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
