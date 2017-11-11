package cs.swe632.smartclassregistration.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cs.swe632.smartclassregistration.springboot.model.Student;

@Transactional
@Repository
public class StudentDAOImpl implements StudentDAO{
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Student getStudentById(int studentId) {
		Student student = entityManager.find(Student.class, studentId);
		return student;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		String hql = "FROM Student as atcl ORDER BY atcl.studentId";
		return (List<Student>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addStudent(Student student) {
		entityManager.persist(student);
	}
	@Override
	public void updateStudent(Student student) {
		Student specificStudent = this.getStudentById(student.getStudentId());
		specificStudent.setTitle(student.getTitle());
		specificStudent.setCategory(student.getCategory());
		entityManager.flush();
	}
	@Override
	public void deleteStudent(int studentId) {
		entityManager.remove(this.getStudentById(studentId));
	}
	@Override
	public boolean studentExists(String title, String category) {
		String hql = "FROM Student as student WHERE student.title = ? and student.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}
}
