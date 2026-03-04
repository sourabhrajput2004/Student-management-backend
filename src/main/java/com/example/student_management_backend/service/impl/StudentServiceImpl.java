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

    // ➕ Save or update student
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // 📄 Get all students
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // ❌ Delete student by id
    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // 🔍 Search student by name
    @Override
    public List<Student> searchByName(String name) {
        return studentRepository.findByNameIgnoreCase(name);
    }

    // 🔍 Search student by course
    @Override
    public List<Student> searchByCourse(String course) {
        return studentRepository.findByCourseIgnoreCase(course);
    }
}