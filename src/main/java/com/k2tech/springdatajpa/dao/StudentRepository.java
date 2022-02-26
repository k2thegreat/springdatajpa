package com.k2tech.springdatajpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByEmailId(String email);

    // Imp - this is non native query (JQL) and Java class name (Student) is used in query and instead of tbl_student and firstName
    // instead of first_name
    // Since this is driven by @Query specified method name can be of developers choice
    @Query(value = "select s from Student s where s.firstName = :firstname")
    List<Student> findByFirstNameJQL(@Param("firstname") String name);

    // Imp - this is native query and table name (tbl_student) is used in query and columns name last_name is used
    // instead of first_name
    // Since this is driven by @Query specified method name can be of developers choice
    @Query(value = "select first_name from tbl_student  where last_name = :lastname",nativeQuery = true)
    List<String> findByLastNameNative(@Param("lastname") String lastName);

    }
