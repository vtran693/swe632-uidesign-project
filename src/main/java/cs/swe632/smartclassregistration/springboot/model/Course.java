package cs.swe632.smartclassregistration.springboot.model;
import java.io.Serializable;

import javax.persistence.*;


@Entity
public class Course implements Serializable{
	
	// Primary Key (Course Name, Course Section ID)
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="course_id")
    private int courseId;

    @Column(name="course_name")
	private String courseName;
	@Column(name="course_section")
	private String courseSection;
	
	@Column(name="course_date")
	private String courseDate;
	
	@Column(name="course_timeperiod")
	private String courseTimePeriod;
	
	@Column(name="course_availability")
	private int courseAvailability;

    @Column(name="course_professor")
    private String courseProfessor;
    
    @Column(name="course_major")
    private String courseMajor;
    
    @Column(name="course_concentration")
    private String courseConcentration;
	
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

    public String getCourseProfessor() {
        return courseProfessor;
    }

    public void setCourseProfessor(String courseProfessor) {
        this.courseProfessor = courseProfessor;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    // Custom method to decrement availability (when someone registers for the course)
	public boolean decrementAvailability() {
		if (this.courseAvailability == 0) {
			return false;
		}
		this.courseAvailability--;
		return true;
	}
	
	// Custom method to increment availability (when someone drops the course registration)
	public boolean incrementAvailability() {
		if (this.courseAvailability > 0) {
			return false;
		}
		this.courseAvailability++;
		return true;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Course)) {
			return false;
		}
		Course course = (Course) o ;
		if (this.courseName.equals(course.courseName) && this.courseSection.equals(course.courseSection)) {
			return true;
		}
		else {
			return false;
		}
	}
}
