package com.example.controller;

import com.example.DTO.StudentDTO;
import com.example.entity.Student;
import com.example.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    //Add Student REST API
    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDto){
        StudentDTO savedStudent = studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    //Get Student by ID REST API
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") Long studentId){
        StudentDTO studentDto = studentService.getStudentById(studentId);
        return ResponseEntity.ok(studentDto);
    }

    //Get All Students REST API
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        List<StudentDTO> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    //Update Student REST API
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable("id") Long studentId, @RequestBody StudentDTO updatedStudent) {
        StudentDTO studentDto = studentService.updateStudent(studentId, updatedStudent);
        return ResponseEntity.ok(updatedStudent);
    }

    //Delete Student REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successfully");

    }

}
