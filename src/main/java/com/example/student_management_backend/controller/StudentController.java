package com.example.student_management_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.student_management_backend.entity.Student;
import com.example.student_management_backend.repository.StudentRepository;
import com.example.student_management_backend.service.StudentService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    // ✅ Add student
    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // ✅ Pagination Enabled GET
    @GetMapping
    public Page<Student> getStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    // ✅ Delete student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    // 🔍 SEARCH API
    @GetMapping("/search")
    public List<Student> searchStudents(
            @RequestParam String type,
            @RequestParam String value) {

        if (type.equalsIgnoreCase("name")) {
            return studentService.searchByName(value);
        } else if (type.equalsIgnoreCase("course")) {
            return studentService.searchByCourse(value);
        }

        return List.of();
    }
}