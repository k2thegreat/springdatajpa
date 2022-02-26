package com.k2tech.springdatajpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.k2tech.springdatajpa.dao.Student;
import com.k2tech.springdatajpa.dao.StudentRepository;

@SpringBootTest
public class StudentRepositoryTest {

  @Autowired StudentRepository studRepo;

  @Test
  public void getAllStudents() {
    List<Student> list = studRepo.findAll();
    System.out.println(list);
  }

  @Test
  public void findByEmailId() {
    List<Student> list = studRepo.findByEmailId("kyru.mirg@gmail.com");
    System.out.println(list);
  }

  //JQL
  @Test
  public void findByFirstName() {
    List<Student> list = studRepo.findByFirstNameJQL("Aashi");
    System.out.println("Students By First Name  (JQL) - "+list);
  }

  // Native
  @Test
  public void findByLAstName() {
    List<String> list = studRepo.findByLastNameNative("Mirg");
    System.out.println("Students By Last Name  (Native) - "+list);
  }

  // Pagination

  @Test
  public void getStudentsPerPage(){
    Pageable pageable = PageRequest.of(0,2);
    Page<Student> students = studRepo.findAll(pageable);
    students.stream().forEach(s -> System.out.println("Student -"+s));
    System.out.println("students = " + students);
    System.out.println("total students = " + students.getTotalElements());
    System.out.println("total pages = " + students.getTotalPages());
  }

  // Pagination

  @Test
  public void getStudentsPerPageSorted(){
    Pageable pageable = PageRequest.of(0, 2, Sort.by("emailId"));
    Page<Student> students = studRepo.findAll(pageable);
    students.stream().forEach(s -> System.out.println("Student -"+s));
    System.out.println("students = " + students);
    System.out.println("total students = " + students.getTotalElements());
    System.out.println("total pages = " + students.getTotalPages());
  }
}
