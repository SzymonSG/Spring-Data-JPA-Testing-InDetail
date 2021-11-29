package com.scotycodebuffer.springdatajpaapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {


    @Id
    @SequenceGenerator(
            name = "sequence_teacher",
            sequenceName = "seqence_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_teacher"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;

    /*@OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="techer_id",
            referencedColumnName = "teacherId"
    )// teacher have list of courses
    private List<Course> courses;*/
    // wczesniej mieliśmy odnieśienie one teacher to Many courses but we want
    // check option with Many to One so delete this

}
