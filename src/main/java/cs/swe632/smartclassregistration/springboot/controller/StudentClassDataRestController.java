package cs.swe632.smartclassregistration.springboot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cs.swe632.smartclassregistration.springboot.model.Course;
import cs.swe632.smartclassregistration.springboot.model.Greeting;
import cs.swe632.smartclassregistration.springboot.model.Student;
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
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable("id") Integer id) {
		Student student = studentService.getStudentById(id);
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
	@DeleteMapping("/student/{id}")
	public void deleteStudent(@PathVariable("id") Integer id) {
		studentService.deleteStudent(id);
	}
	
	
	@GetMapping("/student/get-master-dummy")
	public Student getMasterDummyStudent(){
		
		Student student = new Student();
		student.setStudentId(15);
		student.setTitle("Master");
		student.setCategory("Software Engineer");

		return student;
	}

	@GetMapping("/student/get-undergrad-dummy")
	public Student getUndergradDummyStudent(){
		
		Student student = new Student();
		student.setStudentId(20);
		student.setTitle("Undergrad");
		student.setCategory("Software Engineer");

		return student;
	}
	
	@GetMapping("/class/get-grad-swe-courses")
	public List<Course> getGradSweCourses(){
		List<Course> list = new ArrayList<Course>();
		Course course = new Course();
		course.setName("SWE 632 - User Interface Design and Development");
		list.add(course);
		course = new Course();
		course.setName("SWE 645 - Component-Based Software Development");
		list.add(course);	
		return list;
	}	   	
}