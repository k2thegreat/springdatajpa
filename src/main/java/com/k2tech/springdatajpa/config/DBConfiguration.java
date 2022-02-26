package com.k2tech.springdatajpa.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.k2tech.springdatajpa.dao.Course;
import com.k2tech.springdatajpa.dao.CourseMaterial;
import com.k2tech.springdatajpa.dao.CourseMaterialRepository;
import com.k2tech.springdatajpa.dao.Guardian;
import com.k2tech.springdatajpa.dao.Student;
import com.k2tech.springdatajpa.dao.StudentRepository;
import com.k2tech.springdatajpa.dao.Teacher;

@Configuration
public class DBConfiguration {

  @Autowired StudentRepository studRepo;

  @Autowired CourseMaterialRepository courseMaterialRepository;

  @PostConstruct
  public void loadData() {
    Guardian ketan = new Guardian("Ketan", "ketan.20mirg@gmail.com", "9971795333");
    Student aashi =
        new Student()
            .builder()
            .firstName("Aashi")
            .lastName("Mirg")
            .emailId("me.ashima@gmail.com")
            .guardian(ketan)
            .build();
    Student kyru =
        new Student()
            .builder()
            .firstName("Kyrah")
            .lastName("Mirg")
            .emailId("kyru.mirg@gmail.com")
            .guardian(ketan)
            .build();
    Student sanchit =
        Student.builder()
            .firstName("Sanchit")
            .lastName("Mirg")
            .emailId("sanchitmirg0@gmail.com")
            .guardian(ketan)
            .build();
    List<Student> studentList = new ArrayList<>();
    studentList.add(aashi);
    studentList.add(kyru);
    studentList.add(sanchit);
    studRepo.saveAll(studentList);

    Teacher t = Teacher.builder().name("Prabha").build();
    Course course = Course.builder().courseName("DSA").author("Ketan").teacher(t).build();
    CourseMaterial courseMaterial =
        CourseMaterial.builder()
            .courseMaterialName("DSA Material")
            .course(course)
            .students(studentList)
            .build();
    courseMaterialRepository.save(courseMaterial);
  }
}
