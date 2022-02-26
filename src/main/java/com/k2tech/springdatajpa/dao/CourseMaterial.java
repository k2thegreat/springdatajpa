package com.k2tech.springdatajpa.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_course_material")
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @Column(name = "course_material_id")
    @SequenceGenerator(
            name = "sequence_course_material_id",
            sequenceName = "sequence_course_material_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_course_material_id"
    )
    private Long courseMaterialId;
    private String courseMaterialName;
    @OneToOne(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    @JoinColumn(name = "crs_id",referencedColumnName = "course_id")
    private Course course;

  @ManyToMany(cascade = CascadeType.MERGE)
  @JoinTable(
      name = "coursematerial_student_map",
      joinColumns =
          @JoinColumn(name = "course_material_id", referencedColumnName = "course_material_id"),
      inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"))
  List<Student> students;
}
