package com.example.student_management_backend.service;

import java.util.List;
import com.example.student_management_backend.entity.Student;

public interface StudentService {

    
    Student saveStudent(Student student);

    
    List<Student> getAllStudents();

    
    void deleteStudent(Long id);

    
    List<Student> searchByName(String name);

    
    List<Student> searchByCourse(String course);
}