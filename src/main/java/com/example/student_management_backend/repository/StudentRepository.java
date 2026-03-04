package com.example.student_management_backend.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.student_management_backend.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameIgnoreCase(String name);

    List<Student> findByCourseIgnoreCase(String course);
}
