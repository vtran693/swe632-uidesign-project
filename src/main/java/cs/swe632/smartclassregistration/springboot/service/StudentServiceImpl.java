package cs.swe632.smartclassregistration.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.swe632.smartclassregistration.springboot.dao.StudentDAO;
import cs.swe632.smartclassregistration.springboot.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO studentDAO;
	@Override
	public Student getStudentById(int studentId) {
		Student obj = studentDAO.getStudentById(studentId);
		return obj;
	}	
	@Override
	public List<Student> getAllStudents(){
		return studentDAO.getAllStudents();
	}
	@Override
	public synchronized boolean addStudent(Student student){
		if (studentDAO.studentExists(student.getTitle(), student.getCategory())) {
			return false;
		} else {
			studentDAO.addStudent(student);
			return true;
		}
	}
	@Override
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
	}
	@Override
	public void deleteStudent(int studentId) {
		studentDAO.deleteStudent(studentId);
	}
}
