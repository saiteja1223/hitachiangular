package com.example.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tabel")
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String name ;
private String Addres; 
public long getId() {
    return id;
}
public void setId(long id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getAddres() {
    return Addres;
}
public void setAddres(String addres) {
    Addres = addres;
}
public Student(long id, String name, String addres) {
    this.id = id;
    this.name = name;
   this.Addres = addres;
}
public Student() {
}

    
}
