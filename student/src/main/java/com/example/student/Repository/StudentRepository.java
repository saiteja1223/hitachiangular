package com.example.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>  {
    
}
