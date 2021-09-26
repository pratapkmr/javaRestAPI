package com.spirngrest.springrest.services;

import java.util.List;

import com.spirngrest.springrest.entities.Courses;

public interface CourseServices {
	public List<Courses> getCourses();
	public Courses getCourse(long courseId);
	public Courses addCourse(Courses course);
	public Courses updateCourse(Courses course,int courseId);
	public Courses deleteCourse(int courseId);
}
