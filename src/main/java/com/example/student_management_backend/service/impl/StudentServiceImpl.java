package com.example.student_management_backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_management_backend.entity.Student;
import com.example.student_management_backend.repository.StudentRepository;
import com.example.student_management_backend.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    
    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    
    @Override
    public List<Student> searchByName(String name) {
        return studentRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Student> searchByCourse(String course) {
        return studentRepository.findByCourseIgnoreCase(course);
    }
}
