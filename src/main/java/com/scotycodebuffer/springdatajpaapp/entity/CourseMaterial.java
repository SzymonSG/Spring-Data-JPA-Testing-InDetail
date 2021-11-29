package com.scotycodebuffer.springdatajpaapp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course") // for checking lazy fetch type
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "courseMaterial_generator",
            sequenceName = "courseMaterial_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courseMaterial_generator"
    )
    private Long courseMaterialId;

    private String url;

    @OneToOne(
            //giving permission to child element for persisting
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false // whenever u want save course u need add
            //course material
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;

}
