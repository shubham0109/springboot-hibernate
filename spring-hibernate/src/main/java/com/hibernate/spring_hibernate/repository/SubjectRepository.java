package com.hibernate.spring_hibernate.repository;

import com.hibernate.spring_hibernate.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
