package com.k2tech.springdatajpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.k2tech.springdatajpa.dao.Course;
import com.k2tech.springdatajpa.dao.CourseRepository;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        for(Course c : courses)
    System.out.println("courseRepository = " + c.getCourseMaterial());
    }
}
