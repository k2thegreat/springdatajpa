package com.k2tech.springdatajpa.dao;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_course")
public class Course {

    @Id
    @Column(name = "course_id")
    @SequenceGenerator(
            name = "sequence_course_id",
            sequenceName = "sequence_course_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_course_id"
    )
    private Long courseId;
    private String courseName;
    private String author;

    //For Bi directional Mapping - in order to get Course Material Info in  course which is already mapped in Course Material

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    // Many courses can be taught by One teacher
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teach_id",referencedColumnName = "teacher_id")
    private Teacher teacher;





}
