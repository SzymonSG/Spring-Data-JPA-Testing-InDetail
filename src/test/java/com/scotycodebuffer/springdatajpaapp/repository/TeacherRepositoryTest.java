package com.scotycodebuffer.springdatajpaapp.repository;

import com.scotycodebuffer.springdatajpaapp.entity.Course;
import com.scotycodebuffer.springdatajpaapp.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void SaveTeacher(){
        Course coursePremium = Course.builder()
                .tittle("Pustkowie Sauga")
                .credit(100)
                .build();

        Course courseBasic = Course.builder()
                .tittle("Drużyna Pierścienia")
                .credit(60)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Gandalf")
                .lastName("Baggins")
                //.courses(List.of(coursePremium,courseBasic ))
                .build();

        teacherRepository.save(teacher);
    }
}