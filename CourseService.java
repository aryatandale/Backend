//it is an interface

package com.firstAPI.firstAPI.services;
import java.util.*;

import com.firstAPI.firstAPI.entites.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse( Course course);
	public Course updateCourse( Course course);
	public void deleteCourse(long parselong);
}



	
	
