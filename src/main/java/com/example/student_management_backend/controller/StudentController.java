package com.example.student_management_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.student_management_backend.entity.Student;
import com.example.student_management_backend.repository.StudentRepository;
import com.example.student_management_backend.service.StudentService;

@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://student-management-frontend-pink.vercel.app"
})
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    
    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    
    @GetMapping
    public Page<Student> getStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.saveStudent(student);
    }

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
