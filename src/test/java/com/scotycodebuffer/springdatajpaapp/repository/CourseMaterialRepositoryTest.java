package com.scotycodebuffer.springdatajpaapp.repository;


import com.scotycodebuffer.springdatajpaapp.entity.Course;
import com.scotycodebuffer.springdatajpaapp.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void SaveCourseMaterail(){
        Course course = Course.builder()
                .tittle("React")
                .credit(7)
                .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.react_hooks.com")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test //checking lazy fetch type
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials=
                courseMaterialRepository.findAll();
        System.out.println("coursesMaterials = "+courseMaterials);
    }
}