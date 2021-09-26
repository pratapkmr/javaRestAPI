package com.spirngrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spirngrest.springrest.entities.Courses;

@Service
public class CourseServiceImpl implements CourseServices {
	
	List<Courses> list;
	
	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new Courses(145,"Java Core Course", null));
		list.add(new Courses(146,"Java Core Course", null));
		
	}

	@Override
	public List<Courses> getCourses() {
		 
		return list;
	}
	
	
	@Override	
	public Courses getCourse(long courseId) {
		Courses c=null;
		for(Courses course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;
	}

	@Override
	public Courses addCourse(Courses course) {
		 list.add(course);
		return course;
	}
	
	@Override
	public Courses updateCourse(Courses course,int courseId) {
		list=list.stream().map(c->{
			if(c.getId()==courseId) {
//				 
				c.setTitle(course.getTitle());
				c.setDescription(course.getDescription());
			}
			return c;
		}).collect(Collectors.toList());
		return course;
	}
	
	@Override
	public Courses deleteCourse(int courseId) {
		list=list.stream().filter(c->c.getId()!=courseId).collect(Collectors.toList());
		return null;
	 
	}

}
