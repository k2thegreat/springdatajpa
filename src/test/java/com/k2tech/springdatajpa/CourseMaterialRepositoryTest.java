package com.k2tech.springdatajpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.k2tech.springdatajpa.dao.Course;
import com.k2tech.springdatajpa.dao.CourseMaterial;
import com.k2tech.springdatajpa.dao.CourseMaterialRepository;

@SpringBootTest
public class CourseMaterialRepositoryTest {

    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder().courseName("DSA").author("Ketan").build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .courseMaterialName("DSA Material")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);

    }

    @Test
    public void getCourseMaterial(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }
}
