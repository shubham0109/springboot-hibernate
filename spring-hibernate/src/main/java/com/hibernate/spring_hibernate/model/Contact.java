package com.hibernate.spring_hibernate.model;

import jakarta.persistence.*;

@Entity
public class Contact {

    @Id
    @GeneratedValue
    private long id;

    private long contactNo;

    private String email;

    @OneToOne
    @JoinColumn(name="id")
    private Student student;

    public Contact(){
        super();
    }

    public Contact(long contactNo, String email){
        this.contactNo = contactNo;
        this.email = email;
    }



}
