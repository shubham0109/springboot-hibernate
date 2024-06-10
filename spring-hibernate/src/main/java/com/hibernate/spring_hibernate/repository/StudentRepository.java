package com.hibernate.spring_hibernate.repository;

import com.hibernate.spring_hibernate.model.Student;
import com.hibernate.spring_hibernate.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


   // Student addSubjectToStudent(Student student, Subject subject);

}
