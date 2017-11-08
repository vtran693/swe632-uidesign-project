package cs.swe632.smartclassregistration.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cs.swe632.smartclassregistration.springboot.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
