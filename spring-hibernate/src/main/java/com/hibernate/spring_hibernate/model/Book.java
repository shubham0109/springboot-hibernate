package com.hibernate.spring_hibernate.model;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    private Student student;

    public Book(){
        super();
    }

    public Book(String name){
        this.name = name;
    }

    public void addStudent(Student student){
        this.student = student;
    }
}
