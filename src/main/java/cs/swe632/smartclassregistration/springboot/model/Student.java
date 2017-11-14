package cs.swe632.smartclassregistration.springboot.model;

import javax.persistence.*;

import cs.swe632.smartclassregistration.springboot.model.Course;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Students")
public class Student implements Serializable{
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private String gNumber;
	
//	@NotBlank
//	private String firstName; 
//	@NotBlank
//	private String lastName;  
//	@NotBlank
//	private String email;
//	@NotBlank
//	private String classLevel;   
//	@NotBlank
//	private String major;
//	@NotBlank
//	private String concentration;
//	@NotBlank
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date admissionDate;
//	@NotBlank
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date graduateDate;
//	@NotBlank
//	private String status;
//	@NotBlank
//	private List<Course> courseHistory;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="student_username")
    private String studentUsername;  
	@Column(name="student_gnumber")
    private String studentGNumber;
	// Undergrad vs Grad
	@Column(name="student_level")	
	private String studentClassLevel;  
	@Column(name="student_major")	
	private String studentMajor;	
	@Column(name="student_conc")
	private String studentConcentration;


    @ManyToMany
    @JoinTable(name="SC_Completed",
            joinColumns={@JoinColumn(name="student_username")}, inverseJoinColumns={@JoinColumn(name="course_id")})
	private List<Course> studentCompletedCourses;
	
    @ManyToMany
    @JoinTable(name="SC_Current",
            joinColumns={@JoinColumn(name="student_username")}, inverseJoinColumns={@JoinColumn(name="course_id")})
	private List<Course> studentCurrentRegisteredCourses;
	
	public String getStudentUsername() {
		return studentUsername;
	}
	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}
	public String getStudentGNumber() {
		return studentGNumber;
	}
	public void setStudentGNumber(String studentGNumber) {
		this.studentGNumber = studentGNumber;
	}
	public String getStudentClassLevel() {
		return studentClassLevel;
	}
	public void setStudentClassLevel(String studentClassLevel) {
		this.studentClassLevel = studentClassLevel;
	}
	public String getStudentMajor() {
		return studentMajor;
	}
	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}
	public String getStudentConcentration() {
		return studentConcentration;
	}
	public void setStudentConcentration(String studentConcentration) {
		this.studentConcentration = studentConcentration;
	}
	public List<Course> getStudentCompletedCourses() {
		return studentCompletedCourses;
	}
	public void setStudentCompletedCourses(List<Course> studentCompletedCourses) {
		this.studentCompletedCourses = studentCompletedCourses;
	}
	public List<Course> getStudentCurrentRegisteredCourses() {
		return studentCurrentRegisteredCourses;
	}
	public void setStudentCurrentRegisteredCourses(List<Course> studentCurrentRegisteredCourses) {
		this.studentCurrentRegisteredCourses = studentCurrentRegisteredCourses;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}