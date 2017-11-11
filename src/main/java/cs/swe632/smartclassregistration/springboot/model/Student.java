package cs.swe632.smartclassregistration.springboot.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="Students")
public class Student implements Serializable{
//	@Id
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
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="student_id")
        private int studentId;  
	@Column(name="title")
        private String title;
	@Column(name="student_category")	
	private String category;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}	

}