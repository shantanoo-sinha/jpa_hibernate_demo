package com.example.jpa.hibernate.jpa_hibernate_demo.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.jpa.hibernate.jpa_hibernate_demo.JpaHibernateDemoApplication;
import com.example.jpa.hibernate.jpa_hibernate_demo.entity.Course;

@SpringBootTest(classes = JpaHibernateDemoApplication.class)
class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(CourseRepositoryTest.class);
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	void findById() {
		logger.info("Running findById test");
		Course course = courseRepository.findById(10001L);
		logger.info("Course:" + course);
		assertEquals("Course 1", course.getName());
	}

	@Test
	@DirtiesContext
	void deleteById() {
		logger.info("Running deleteById test");
		courseRepository.deleteById(10002L);
		assertNull(courseRepository.findById(10002L));
	}
	
	@Test
	@DirtiesContext
	void save() {
		logger.info("Running save test");
		Course course = courseRepository.findById(10002L);
		logger.info("Course:" + course);
		assertEquals("Course 2", course.getName());
		
		course.setName("Course 2 - Updated");
		courseRepository.save(course);
		
		Course updatedCourse = courseRepository.findById(10002L);
		assertEquals("Course 2 - Updated", updatedCourse.getName());
	}
}
