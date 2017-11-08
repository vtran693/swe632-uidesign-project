package cs.swe632.smartclassregistration.springboot.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="Students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String gNumber;
	
	@NotBlank
	private String firstName; 
	@NotBlank
	private String lastName;  
	
	private String email;
	@NotBlank
	private String classLevel;    
	private String major;
	@NotBlank
	private String concentration;
	@NotBlank
	@Temporal(TemporalType.TIMESTAMP)
	private Date admissionDate;
	
	private Date graduateDate;
	private String status;
	
	private List<Course> courseHistory;

}