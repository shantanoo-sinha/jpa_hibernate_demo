/**
 * 
 */
package com.example.jpa.hibernate.jpa_hibernate_demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Shantanoo
 *
 */
@Entity
public class Course {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	/**
	 * 
	 */
	public Course() {
		super();
	}

	/**
	 * @param name
	 */
	public Course(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
}
