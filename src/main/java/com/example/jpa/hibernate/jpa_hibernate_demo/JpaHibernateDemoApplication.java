package com.example.jpa.hibernate.jpa_hibernate_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.hibernate.jpa_hibernate_demo.entity.Course;
import com.example.jpa.hibernate.jpa_hibernate_demo.repository.CourseRepository;

@SpringBootApplication
public class JpaHibernateDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(JpaHibernateDemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateDemoApplication.class, args);
	}
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public void run(String... args) throws Exception {
		Course course = courseRepository.findById(10001L);
		logger.info("Course:" + course);
/*		course.setName("Course 1 - Updated");
		Course newcourse1 = courseRepository.save(course);
		logger.info("Course:" + newcourse1);*/
	}

}
