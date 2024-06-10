package com.hibernate.spring_hibernate;

import com.hibernate.spring_hibernate.model.Student;
import com.hibernate.spring_hibernate.model.Subject;
import com.hibernate.spring_hibernate.repository.StudentRepository;
import com.hibernate.spring_hibernate.repository.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootApplication
public class SpringHibernateApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	SubjectRepository subjectRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {

		SpringApplication.run(SpringHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Student id 101 is {}", studentRepository.findById(101L));
		logger.info("All students: {}", studentRepository.findAll());
		logger.info("Add a student {}", studentRepository.save(new Student(1,"John")));
		logger.info("Add a student {}", studentRepository.save(new Student("Jane")));

		Student shubham = studentRepository.findById(101L).orElseThrow(()->new NoSuchElementException());
		Subject physics = subjectRepository.findById(201L).orElseThrow(()->new NoSuchElementException());

		//logger.info("Add Subject for a student ", shubham.addSubject(physics));
		shubham.addSubject(physics);
		shubham.addAddress("jewelo, raipur");
		shubham.addAddress("panathur, bangalore");
		studentRepository.save(shubham);

		Student shubh = studentRepository.findById(101L).orElseThrow(() -> new NoSuchElementException());
		System.out.println(shubh.getAllSubject());



	}
}
