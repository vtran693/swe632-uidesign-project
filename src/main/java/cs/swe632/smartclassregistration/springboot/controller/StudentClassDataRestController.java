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
        

        
		Course cs584Section1 = new Course();
		swe645Section1.setCourseId(3);
		swe645Section1.setCourseName("CS584");
		swe645Section1.setCourseSection("01");
		swe645Section1.setCourseMajor("CS");
		swe645Section1.setCourseConcentration("Core");
		swe645Section1.setCourseDate("Tue");
		swe645Section1.setCourseTimePeriod("7:20-10:00");
		swe645Section1.setCourseAvailability(1);
		swe645Section1.setCourseProfessor("Jessica Lin");
        this.addCourseSetup(cs584Section1);
        
        
		Course cs583Section1 = new Course();
		cs583Section1.setCourseId(4);
		cs583Section1.setCourseName("CS583");
		cs583Section1.setCourseSection("01");
		cs583Section1.setCourseMajor("CS");
		cs583Section1.setCourseConcentration("Core");
		cs583Section1.setCourseDate("Wed");
		cs583Section1.setCourseTimePeriod("4:30-7:10");
		cs583Section1.setCourseAvailability(1);
		cs583Section1.setCourseProfessor("Dana S Richards");
        this.addCourseSetup(cs583Section1);
        
        
		Course cs550Section1 = new Course();
		cs550Section1.setCourseId(5);
		cs550Section1.setCourseName("CS550");
		cs550Section1.setCourseSection("01");
		cs550Section1.setCourseMajor("CS");
		cs550Section1.setCourseConcentration("Core");
		cs550Section1.setCourseDate("Thur");
		cs550Section1.setCourseTimePeriod("4:30-7:10");
		cs550Section1.setCourseAvailability(1);
		cs550Section1.setCourseProfessor("Jessica Lin");
        this.addCourseSetup(cs550Section1);
        
        
		Course swe621Section1 = new Course();
		swe621Section1.setCourseId(6);
		swe621Section1.setCourseName("SWE621");
		swe621Section1.setCourseSection("01");
		swe621Section1.setCourseMajor("SWE");
		swe621Section1.setCourseConcentration("Software Development");
		swe621Section1.setCourseDate("Tue");
		swe621Section1.setCourseTimePeriod("7:20-10:00");
		swe621Section1.setCourseAvailability(1);
		swe621Section1.setCourseProfessor("Hassan Gomaa");
        this.addCourseSetup(swe621Section1);
             
    	Course cs530Section1 = new Course();
    	cs530Section1.setCourseId(13);
    	cs530Section1.setCourseName("CS530");
    	cs530Section1.setCourseSection("02");
    	cs530Section1.setCourseMajor("CS");
    	cs530Section1.setCourseConcentration("Pre-requisite");
    	cs530Section1.setCourseDate("Tue");
    	cs530Section1.setCourseTimePeriod("7:20-10:00");
    	cs530Section1.setCourseAvailability(1);
    	cs530Section1.setCourseProfessor("Dmitri Kaznachey");
        this.addCourseSetup(cs530Section1);
              
      	Course isa562Section1 = new Course();
      	isa562Section1.setCourseId(14);
      	isa562Section1.setCourseName("ISA562");
      	isa562Section1.setCourseSection("01");
      	isa562Section1.setCourseMajor("ISA");
      	isa562Section1.setCourseConcentration("Core");
      	isa562Section1.setCourseDate("Wed");
      	isa562Section1.setCourseTimePeriod("4:30-7:10");
      	isa562Section1.setCourseAvailability(1);
      	isa562Section1.setCourseProfessor("Arun K Sood");
        this.addCourseSetup(isa562Section1);
        
        Course cs650Section1 = new Course();
        cs650Section1.setCourseId(15);
        cs650Section1.setCourseName("CS650");
        cs650Section1.setCourseSection("01");
        cs650Section1.setCourseMajor("CS");
        cs650Section1.setCourseConcentration("Databases");
        cs650Section1.setCourseDate("Thu");
        cs650Section1.setCourseTimePeriod("4:30-7:10");
        cs650Section1.setCourseAvailability(1);
        cs650Section1.setCourseProfessor("Amihai Motro");
        this.addCourseSetup(isa562Section1);
        
        Course cs818Section1 = new Course();
        cs818Section1.setCourseId(16);
        cs818Section1.setCourseName("CS818");
        cs818Section1.setCourseSection("01");
        cs818Section1.setCourseMajor("CS");
        cs818Section1.setCourseConcentration("Networks");
        cs818Section1.setCourseDate("Tue");
        cs818Section1.setCourseTimePeriod("4:30-7:10");
        cs818Section1.setCourseAvailability(1);
        cs818Section1.setCourseProfessor("Song Min Kim");
        this.addCourseSetup(cs818Section1);
        
        Course cs531Section1 = new Course();
      	cs531Section1.setCourseId(17);
      	cs531Section1.setCourseName("CS531");
      	cs531Section1.setCourseSection("02");
      	cs531Section1.setCourseMajor("CS");
      	cs531Section1.setCourseConcentration("Pre-requisite");
      	cs531Section1.setCourseDate("Tue");
      	cs531Section1.setCourseTimePeriod("4:30-7:10");
      	cs531Section1.setCourseAvailability(1);
      	cs531Section1.setCourseProfessor("Harrold Greenwald");
        this.addCourseSetup(cs531Section1);
        
        Course cs630Section1 = new Course();
        cs630Section1.setCourseId(18);
        cs630Section1.setCourseName("CS630");
        cs630Section1.setCourseSection("02");
        cs630Section1.setCourseMajor("CS");
        cs630Section1.setCourseConcentration("Algorithms");
        cs630Section1.setCourseDate("Tue");
        cs630Section1.setCourseTimePeriod("4:30-7:10");
        cs630Section1.setCourseAvailability(1);
        cs630Section1.setCourseProfessor("Fei Li");
        this.addCourseSetup(cs630Section1);
        
		Course swe642Section1 = new Course();
		swe642Section1.setCourseId(19);
		swe642Section1.setCourseName("SWE642");
		swe642Section1.setCourseSection("01");
		swe642Section1.setCourseMajor("SWE");
		swe642Section1.setCourseConcentration("Web");
		swe642Section1.setCourseDate("Tue");
		swe642Section1.setCourseTimePeriod("7:20-10:00");
		swe642Section1.setCourseAvailability(1);
		swe645Section1.setCourseProfessor("Vinod K Dubey");
        this.addCourseSetup(swe642Section1); 

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
        studentService.setStudentCompletedCourses("vtran18", cs583Section1);
        studentService.setStudentCompletedCourses("vtran18", cs818Section1);
        studentService.setStudentCompletedCourses("vtran18", swe621Section1);
        studentService.setStudentCurrentRegisteredCourses("vtran18", swe645Section1);
        
        
        
		Student nuthanaTatineni = new Student();
		nuthanaTatineni.setStudentUsername("ntatinen");
		nuthanaTatineni.setStudentName("Nuthana Tatineni");
		nuthanaTatineni.setStudentLinkedIn("https://www.linkedin.com/in/nuthanat/");
		nuthanaTatineni.setStudentGNumber("G01003061");
		nuthanaTatineni.setStudentClassLevel("Graduate");
		nuthanaTatineni.setStudentMajor("Computer Science");
		nuthanaTatineni.setStudentConcentration("Web Development");
		
        this.addStudentSetup(nuthanaTatineni); 
        
        studentService.setStudentCompletedCourses("ntatinen", cs583Section1);
        studentService.setStudentCompletedCourses("ntatinen", cs550Section1);
        studentService.setStudentCompletedCourses("ntatinen", swe621Section1);
        studentService.setStudentCompletedCourses("ntatinen", cs530Section1);
        studentService.setStudentCompletedCourses("ntatinen", cs531Section1);
        studentService.setStudentCompletedCourses("ntatinen", isa562Section1);
        studentService.setStudentCompletedCourses("ntatinen", cs650Section1);
        studentService.setStudentCompletedCourses("ntatinen", cs818Section1);
        studentService.setStudentCurrentRegisteredCourses("ntatinen", cs584Section1);

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