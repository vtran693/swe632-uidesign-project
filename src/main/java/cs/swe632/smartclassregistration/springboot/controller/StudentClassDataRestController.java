package cs.swe632.smartclassregistration.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cs.swe632.smartclassregistration.springboot.model.Course;
import cs.swe632.smartclassregistration.springboot.model.Student;
import cs.swe632.smartclassregistration.springboot.service.CourseService;
import cs.swe632.smartclassregistration.springboot.service.StudentService;

@RequestMapping("/api")
@RestController
public class StudentClassDataRestController {

//    private static final String template = "Hello, %s!";
//    private static final String templateOther = "Hello, %s! You are number %d";
//    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping("/")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name));
//    }
//    
//    @RequestMapping("/{name}/{id}")
//    public Greeting greetingWithPathVariable(@PathVariable(value="name") String name, @PathVariable(value="id") int id) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(templateOther, name, id));
//    }
//    
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("/student/{username}")
	public Student getStudentByUsername(@PathVariable("username") String studentUsername) {
		Student student = studentService.getStudentByUsername(studentUsername);
		return student;
	}	
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		List<Student> list = studentService.getAllStudents();
		return list;
	}
	@PostMapping("/student")
	public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);    
	}
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
		return student;
	}
	@DeleteMapping("/student/{username}")
	public void deleteStudent(@PathVariable("username") String studentUsername) {
		studentService.deleteStudent(studentUsername);
	}
	
	@GetMapping("/student/{username}/completed-courses")
	public List<Course> getStudentCompletedCourses(@PathVariable("username") String studentUsername) {
		List<Course> completedCourses = studentService.getStudentCompletedCourses(studentUsername);
		return completedCourses;
	}
	
	@GetMapping("/student/{username}/current-registered-courses")
	public List<Course> getStudentCurrentRegisteredCourses(@PathVariable("username") String studentUsername) {
		List<Course> currentRegisteredCourses = studentService.getStudentCurrentRegisteredCourses(studentUsername);
		return currentRegisteredCourses;
	}
	
	@PutMapping("/student/{username}/register")
	public String registerCourse(@PathVariable("username") String studentUsername, @RequestBody Course course) {
		return studentService.registerCourse(studentUsername, course);
	}
	
	@PutMapping("/student/{username}/drop")
	public String dropCourse(@PathVariable("username") String studentUsername, @RequestBody Course course) {
		return studentService.dropCourse(studentUsername, course);
	}
	
	// Course API
	@PostMapping("/course")
	public boolean addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);    
	}
	
	private boolean addCourseSetup(Course course) {
		return courseService.addCourse(course);
	}
	
	@GetMapping("/course/setup")
	public void setupCourse() {
		Course swe632Section1 = new Course();
		swe632Section1.setCourseId(1);
		swe632Section1.setCourseName("SWE632");
		swe632Section1.setCourseSection("01");
		swe632Section1.setCourseMajor("SWE");
		swe632Section1.setCourseConcentration("Design");
		swe632Section1.setCourseDate("Wed");
		swe632Section1.setCourseTimePeriod("7:20-10:00");
		swe632Section1.setCourseAvailability(1);
		swe632Section1.setCourseProfessor("Feras Batarseh");
		
        this.addCourseSetup(swe632Section1); 
	}
	
	
//	@GetMapping("/student/get-master-dummy")
//	public Student getMasterDummyStudent(){
//		
//		Student student = new Student();
//		student.setStudentId(15);
//		student.setTitle("Master");
//		student.setCategory("Software Engineer");
//
//		return student;
//	}
//
//	@GetMapping("/student/get-undergrad-dummy")
//	public Student getUndergradDummyStudent(){
//		
//		Student student = new Student();
//		student.setStudentId(20);
//		student.setTitle("Undergrad");
//		student.setCategory("Software Engineer");
//
//		return student;
//	}
//	
//	@GetMapping("/class/get-grad-swe-courses")
//	public List<Course> getGradSweCourses(){
//		List<Course> list = new ArrayList<Course>();
//		Course course = new Course();
//		course.setName("SWE 632 - User Interface Design and Development");
//		list.add(course);
//		course = new Course();
//		course.setName("SWE 645 - Component-Based Software Development");
//		list.add(course);	
//		return list;
//	}	   	
}