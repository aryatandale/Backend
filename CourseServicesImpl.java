package com.firstAPI.firstAPI.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.stereotype.Service;

import com.firstAPI.firstAPI.entites.Course;

@Service

public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	public CourseServiceImpl()
	{
		list = new ArrayList<>();
		list.add(new Course(1,"Math","First Yera"));
		list.add(new Course(2,"English","Second Yera"));
		
	}
	@Override
	public List<Course> getCourses() {
		
		return list;
	}
	@Override
	public Course getCourse(long courseId) {
		Course c = null;
		for(Course course: list)
		{
			if(course.getId()==courseId)
			{
				c = course;
				break;
				
			}
		}
		
		return c;
	}
	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}
	@Override
	public Course updateCourse(Course course) {
		list.forEach(e -> {
			if(e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription( course.getDescription());
			}
		});
		return course;
	}
	@Override
	public void deleteCourse(long parselong) {
		
		list=this.list.stream().filter(e->e.getId()!=parselong).collect(Collector.toList());
		
	}

}
