package com.example.student.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.Repository.StudentRepository;
import com.example.student.exception.resourceNotFoundException;
import com.example.student.model.Student;

@RestController
@RequestMapping("/api/v1/student")
@CrossOrigin(origins="http://localhost:4200")

public class StudentController {
    @Autowired
    public StudentRepository studentRepository;
    
    @GetMapping
    public List<Student> getQues(){
        return studentRepository.findAll();
    }
    @PostMapping
    public Student fun(@RequestBody Student student ){
        return studentRepository.save(student);
    }
    @DeleteMapping
    public void deletemap()
    {
        studentRepository.deleteAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateDetails(@PathVariable("id")long id,@RequestBody Student student)
    {
        
        Student updaStudent=studentRepository.findById(id).orElseThrow(() -> new resourceNotFoundException("Employee not exist with id: " + id));
        
        updaStudent.setName(student.getName());
        updaStudent.setAddres(student.getAddres());
        studentRepository.save(updaStudent);
        return ResponseEntity.ok(updaStudent);


    }
    @DeleteMapping("/{id}")
    public void deleteby(@PathVariable("id") long id){
        studentRepository.deleteById(id);
    }
    @GetMapping("/{id}")
    public Student gepStudent(@PathVariable("id") long id){
        return  studentRepository.findById(id).orElseThrow(() -> new resourceNotFoundException("Employee not exist with id: " + id));


    }

    
}
