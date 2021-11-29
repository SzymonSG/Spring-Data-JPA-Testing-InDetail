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
@Table(
        name= "tbl_student1",
        uniqueConstraints = @UniqueConstraint(
                name = "emailID_unique",
                columnNames = "email_Addres"
        )
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "generator_SEQ",
            sequenceName = "seq_generator",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "generator_SEQ"
    )
    private Long id;
    private String firstName;
    private String lastName;
    @Column(
            name = "email_addres",
            nullable = false
    )
    private String emailId;

    @Embedded // osadzenie pól poprzez @Embeddable
    private Guardian guardian;

}
