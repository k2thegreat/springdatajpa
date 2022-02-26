package com.k2tech.springdatajpa.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_teacher")
public class Teacher {
    @Id
    @Column(name = "teacher_id")
    @SequenceGenerator(
            name = "sequence_teacher_id",
            sequenceName = "sequence_teacher_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_teacher_id"
    )
    private Long teacherId;
    private String name;
    @OneToMany(mappedBy = "teacher")

    private List<Course> courses;
}
