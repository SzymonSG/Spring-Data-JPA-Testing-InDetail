package com.scotycodebuffer.springdatajpaapp.repository;

import com.scotycodebuffer.springdatajpaapp.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    Page<Course> findByTittleContaining(String tittle, Pageable pageRequest);

    // szukaj np kursów w cenie mniejszej niż
    List<Course> findByCreditIsLessThan(Integer credit);

    List<Course> findByTittleOrderByCreditDesc (String tittle);




}
