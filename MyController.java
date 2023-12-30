package com.firstAPI.firstAPI.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import com.firstAPI.firstAPI.entites.Course;
import com.firstAPI.firstAPI.services.CourseService;

import java.util.*;


@RestController


public class MyController {
	
	@Autowired
	private CourseService courseService; //declaring variable
	
	
	@GetMapping("/home")
	public String home()
	{
		return "Welcome to course application";
	}
	
	
	//get all courses 
	@GetMapping("/Courses")
	public List<Course> getCourses()
	{
		return this.courseService.getCourses();
	}
	
	//get particular course based on courseId
	@GetMapping("/Courses/{courseId}")
	public Course getCourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	//add course
	@PostMapping("/Courses")
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseService.addCourse(course);
	}
	
	//update course using put 
	@PutMapping("/Courses")
	public Course updateCourse(@RequestBody Course course)
	{
		return this.courseService.updateCourse(course);
	}
	
	//delete the course
	@DeleteMapping("/Courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
