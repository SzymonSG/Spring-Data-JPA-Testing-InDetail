package com.scotycodebuffer.springdatajpaapp.repository;

import com.scotycodebuffer.springdatajpaapp.entity.Guardian;
import com.scotycodebuffer.springdatajpaapp.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    // drugi raz ten test się nie wykona ponieważ emailid_unique
    @Test
    public void saveStudent(){
        Student student =  Student.builder()
                .emailId("scoty@gmail.com")
                .firstName("Scotty")
                .lastName("Mates")
                //.guardianName("Niki")
                //.guardianEmail("niki@gmail.com")
                //.guardianMobile("2132145235")
                .build();
        studentRepository.save(student);
    }

    @Test // drugi raz ten test się nie wykona ponieważ emailid_unique
    public void saveStudentandGuardian(){
        Guardian guardian = Guardian.builder()
                .email("tom@gmail.com")
                .name("Balo")
                .mobile("34456634623")
                .build();

        Student student = Student.builder()
                .emailId("tyt@gmail.com")
                .firstName("Scotty")
                .lastName("Kol")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

   @Test
   public void printAllStudent(){
       List<Student> studentList =
               studentRepository.findAll();
       System.out.println("studentList = "+ studentList);
   }

   @Test
   public void printStudentByFirstNameContaining(){
       List<Student> students = studentRepository.findByFirstNameContaining("Sc");

       System.out.println("students = " + students);
   }
    ///my test
    @Test
    public void printStudentByFirstNameAndEmailId(){
        List<Student> students = studentRepository.findByFirstNameAndEmailId("Locky","my@gmail.com");
        System.out.println("found student after name and e-mail= " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> guardianName = studentRepository.findByGuardianName("Andrew");
        System.out.println("students with guardian like Andrew:" + guardianName);
    }

    //doczytaj
   @Test
   public void findDistinctValuesWithTheSameFirstAndLastName(){
       List<Student> distinctByFirstNameAndLastName = studentRepository.findDistinctByFirstNameAndLastName("Locky","Michak");
       System.out.println("distinct "+ distinctByFirstNameAndLastName);
   }

    @Test
    public void printgetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("scoty@gmail.com");
        System.out.println("student finding by unique mail "+student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstName=
                studentRepository.getStudentFirstNameByEmailAddress("tyt@gmail.com");

        System.out.println("Student with mail like tyt@gmail.com has name: " + firstName);
    }
    @Test
    public void printgetgetStudentByEmailAddresNative(){
        Student student
                = studentRepository.getStudentByEmailAddresNative("tyt@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentByEmailAddresNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddresNativeNamedParam("my@gmail.com");
        System.out.println("student query param" + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "Scotty Bowl",
                "tyt@gmail.com"
        );
    }






}