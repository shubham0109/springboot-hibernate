package com.hibernate.spring_hibernate.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name="student_address")
    @Column(name="address")
    private List<String> address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="STUDENT_SUBJECT_JOIN", joinColumns = {@JoinColumn(name = "STUDENT_ID")}, inverseJoinColumns = {@JoinColumn(name = "SUBJECT_ID")})
    private List<Subject> subjects;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student",  cascade = CascadeType.PERSIST)
    private List<Book> books;

    @OneToOne(mappedBy = "student")
    private Contact contact;


    public Student(){
        super();
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getAddress() {
        return address;
    }

    public void addAddress(String address) {
        this.address.add(address);
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public List<Subject> getAllSubject(){
        return subjects;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> getAllBook(){
        return books;
    }

    public void addContact(Contact contact){
        this.contact = contact;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
