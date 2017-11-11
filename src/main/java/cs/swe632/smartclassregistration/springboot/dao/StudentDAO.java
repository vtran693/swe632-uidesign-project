package cs.swe632.smartclassregistration.springboot.dao;

import java.util.List;

import cs.swe632.smartclassregistration.springboot.model.Student;

public interface StudentDAO {
    List<Student> getAllStudents();
    Student getStudentById(int studentId);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);
    boolean studentExists(String title, String category);
}
