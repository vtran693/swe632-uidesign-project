package cs.swe632.smartclassregistration.springboot.service;

import java.util.List;

import cs.swe632.smartclassregistration.springboot.model.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(int studentId);
    boolean addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);
}
