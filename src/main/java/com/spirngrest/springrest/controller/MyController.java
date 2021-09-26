package com.spirngrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spirngrest.springrest.entities.Courses;
import com.spirngrest.springrest.services.CourseServices;

@RestController
public class MyController {
	
	@Autowired
	private CourseServices courseService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to course application";
	}
	
	@GetMapping("/courses")
	public List<Courses> getCourses(){
		return this.courseService.getCourses();
		
	}
	
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Courses createCourse(@RequestBody Courses course) {
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/courses/{courseId}")
	public Courses updateCouse(@RequestBody Courses course,@PathVariable("courseId") int courseId) {
		this.courseService.updateCourse(course,courseId);
		return course;
	}
	
	@DeleteMapping("/courses/{courseId}")	
	public Courses deleteCourse(@PathVariable("courseId") int courseId) {
		return this.courseService.deleteCourse(courseId);
	
	}
}
