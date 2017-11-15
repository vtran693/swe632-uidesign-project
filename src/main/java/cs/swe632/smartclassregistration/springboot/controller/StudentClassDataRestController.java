package cs.swe632.smartclassregistration.springboot.controller;

import java.util.ArrayList;
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
	private boolean addStudentSetup(Student student) {
		return studentService.addStudent(student);
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
		return student;
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
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	
	@GetMapping("/courses/undergrad")
	public List<Course> getAllUndergradCourses(){
		return courseService.getAllUndergradCourses();
	}
	@GetMapping("/courses/undergrad/swe")
	public List<Course> getAllUndergradCoursesSwe(){
		return courseService.getAllUndergradCoursesSwe();
	}
	@GetMapping("/courses/undergrad/cs")
	public List<Course> getAllUndergradCoursesCs(){
		return courseService.getAllUndergradCoursesCs();
	}
	@GetMapping("/courses/grad")
	public List<Course> getAllGradCourses(){
		return courseService.getAllGradCourses();
	}
	@GetMapping("/courses/grad/swe")
	public List<Course> getAllGradCoursesSwe(){
		return courseService.getAllGradCoursesSwe();
	}
	@GetMapping("/courses/grad/cs")
	public List<Course> getAllGradCoursesCs(){
		return courseService.getAllGradCoursesCs();
	}
	
	@PostMapping("/course")
	public boolean addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);    
	}
	
	private boolean addCourseSetup(Course course) {
		return courseService.addCourse(course);
	}
	
	
	@GetMapping("/course/setup")
	public String setupCourse() {
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
  
		Course swe645Section1 = new Course();
		swe645Section1.setCourseId(2);
		swe645Section1.setCourseName("SWE645");
		swe645Section1.setCourseSection("01");
		swe645Section1.setCourseMajor("SWE");
		swe645Section1.setCourseConcentration("Web");
		swe645Section1.setCourseDate("Thur");
		swe645Section1.setCourseTimePeriod("7:20-10:00");
		swe645Section1.setCourseAvailability(1);
		swe645Section1.setCourseProfessor("Vinod Dubey");
        this.addCourseSetup(swe645Section1); 
        
        Course swe205Section1 = new Course();
        swe205Section1.setCourseId(7);
        swe205Section1.setCourseName("SWE205");
        swe205Section1.setCourseSection("01");
        swe205Section1.setCourseMajor("SWE");
        swe205Section1.setCourseConcentration("Analysis");
        swe205Section1.setCourseDate("Wed");
        swe205Section1.setCourseTimePeriod("1:30-4:10");
        swe205Section1.setCourseAvailability(1);
        swe205Section1.setCourseProfessor("Kinga Dobolyi");
        this.addCourseSetup(swe205Section1);
        
        Course swe321Section2 = new Course();
        swe321Section2.setCourseId(8);
        swe321Section2.setCourseName("SWE321");
        swe321Section2.setCourseSection("02");
        swe321Section2.setCourseMajor("SWE");
        swe321Section2.setCourseConcentration("Engeneering");
        swe321Section2.setCourseDate("Tue");
        swe321Section2.setCourseTimePeriod("1:30-4:10");
        swe321Section2.setCourseAvailability(1);
        swe321Section2.setCourseProfessor("Sam Malek");
        this.addCourseSetup(swe321Section2);
        
        Course swe437Section1 = new Course();
        swe437Section1.setCourseId(9);
        swe437Section1.setCourseName("SWE437");
        swe437Section1.setCourseSection("01");
        swe437Section1.setCourseMajor("SWE");
        swe437Section1.setCourseConcentration("Testing");
        swe437Section1.setCourseDate("Wed");
        swe437Section1.setCourseTimePeriod("9:20-12:00");
        swe437Section1.setCourseAvailability(1);
        swe437Section1.setCourseProfessor("Paul Ammann");
        this.addCourseSetup(swe437Section1);
        
        Course cs471Section2 = new Course();
        cs471Section2.setCourseId(10);
        cs471Section2.setCourseName("SWE471");
        cs471Section2.setCourseSection("02");
        cs471Section2.setCourseMajor("CS");
        cs471Section2.setCourseConcentration("Design");
        cs471Section2.setCourseDate("Mon");
        cs471Section2.setCourseTimePeriod("9:20-12:00");
        cs471Section2.setCourseAvailability(1);
        cs471Section2.setCourseProfessor("Daniel Barbará");
        this.addCourseSetup(cs471Section2);
        
        Course cs310Section1 = new Course();
        cs310Section1.setCourseId(11);
        cs310Section1.setCourseName("CS310");
        cs310Section1.setCourseSection("01");
        cs310Section1.setCourseMajor("CS");
        cs310Section1.setCourseConcentration("Analysis");
        cs310Section1.setCourseDate("Mon");
        cs310Section1.setCourseTimePeriod("1:30-4:10");
        cs310Section1.setCourseAvailability(1);
        cs310Section1.setCourseProfessor("Jyh Ming Lien");
        this.addCourseSetup(cs310Section1);
        
        Course cs484Section1 = new Course();
        cs484Section1.setCourseId(12);
        cs484Section1.setCourseName("CS484");
        cs484Section1.setCourseSection("01");
        cs484Section1.setCourseMajor("CS");
        cs484Section1.setCourseConcentration("Design");
        cs484Section1.setCourseDate("Tue");
        cs484Section1.setCourseTimePeriod("9:20-12:00");
        cs484Section1.setCourseAvailability(1);
        cs484Section1.setCourseProfessor("Harry Wechsler");
        this.addCourseSetup(cs484Section1);
        
        
		Student vietTran = new Student();
		vietTran.setStudentUsername("vtran18");
		vietTran.setStudentName("Viet Tran");
		vietTran.setStudentLinkedIn("https://www.linkedin.com/in/viet-tran-272570108/");
		vietTran.setStudentGNumber("G012345678");
		vietTran.setStudentClassLevel("Graduate");
		vietTran.setStudentMajor("SWE");
		vietTran.setStudentConcentration("Web Development");
		
		Student divyaVajja = new Student();
		divyaVajja.setStudentUsername("dvajja");
		divyaVajja.setStudentName("Divya Vajja");
		divyaVajja.setStudentLinkedIn("http://www.linkedin.com/in/divya-vajja-ab80a478");
		divyaVajja.setStudentGNumber("G00996243");
		divyaVajja.setStudentClassLevel("Under Graduate");
		divyaVajja.setStudentMajor("SWE");
		divyaVajja.setStudentConcentration("Software Development");
		
        this.addStudentSetup(vietTran); 
        
        studentService.setStudentCompletedCourses("vtran18", swe632Section1);
        studentService.setStudentCurrentRegisteredCourses("vtran18", swe645Section1);
        studentService.setStudentCompletedCourses("dvajja", swe205Section1);
        studentService.setStudentCompletedCourses("dvajja", swe321Section2);
        studentService.setStudentCompletedCourses("dvajja", cs310Section1);
        studentService.setStudentCurrentRegisteredCourses("dvajja", cs471Section2);
        studentService.setStudentCurrentRegisteredCourses("dvajja", cs484Section1);
       

        
        return "success";
	}
	
	@GetMapping("/course/{name}/{section}/delete")
	public String deleteCourseWithNameAndSection(@PathVariable("name") String courseName, @PathVariable("section") String courseSection) {
		courseService.deleteCourse(courseName, courseSection);
		return "delete success";
	}
	
	
	
	@GetMapping("/student/{username}/completed")
	public List<Course> getStudentCompletedCoursesByService(@PathVariable("username") String studentUsername){
		Student student = studentService.getStudentByUsername(studentUsername);
		return student.getStudentCompletedCourses();
	}
	
	@GetMapping("/student/{username}/delete")
	public String deleteStudent(@PathVariable("username") String studentUsername) {
		studentService.deleteStudent(studentUsername);
		return "delete success";
	}
 	
}