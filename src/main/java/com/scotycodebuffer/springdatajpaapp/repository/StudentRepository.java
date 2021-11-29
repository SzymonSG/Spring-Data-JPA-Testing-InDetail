package com.scotycodebuffer.springdatajpaapp.repository;

import com.scotycodebuffer.springdatajpaapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

        List<Student> findByFirstName(String firstName);

        List<Student> findByFirstNameContaining(String name);

        List<Student> findByFirstNameAndEmailId(String firstName, String emailId);

        List<Student> findByLastNameNotNull();

        List<Student> findByGuardianName(String guardianName);

        //check this
        List<Student> findDistinctByFirstNameAndLastName(String firstName, String lastName);

        Student findByFirstNameAndLastName(String firstName,String lastName);
        //JPQL
        // working on class propoties not on database columns ?1 first parameter
        @Query("select s from Student s where s.emailId = ?1")
        Student getStudentByEmailAddress(String emailId);

        @Query("select s.firstName from Student s where s.emailId = ?1")
        String getStudentFirstNameByEmailAddress(String emailId);

        //Native
        @Query(
                value = "SELECT * FROM tbl_student1 s where s.email_addres = ?1",
                nativeQuery = true
        )
        Student getStudentByEmailAddresNative(String emailId);

        //Native using Param
        @Query(
                value = "SELECT * FROM tbl_student1 s where s.email_addres = :emailId",
                nativeQuery = true
        )
        Student getStudentByEmailAddresNativeNamedParam(
                @Param("emailId") String emailId);

        @Modifying
        @Transactional
        @Query(
                value = "update tbl_student1 set first_name = ?1 where email_addres= ?2",
                nativeQuery = true
        )
        int updateStudentNameByEmailId(String firstName, String emailId);// nazwyw paramterów mogą być dowolne lecz po co





}
