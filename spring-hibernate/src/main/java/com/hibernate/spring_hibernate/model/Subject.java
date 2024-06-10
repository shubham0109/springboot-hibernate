package com.hibernate.spring_hibernate.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany(mappedBy = "subjects", fetch = FetchType.EAGER)
    private List<Student> students;


    public Subject(){
        super();
    }

    public Subject(String name) {
        this.name = name;
    }

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

    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> getAllStudent(){
        return students;
    }


    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
