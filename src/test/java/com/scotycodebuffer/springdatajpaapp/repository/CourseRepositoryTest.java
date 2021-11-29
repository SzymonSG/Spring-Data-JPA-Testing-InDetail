package com.scotycodebuffer.springdatajpaapp.repository;

import com.scotycodebuffer.springdatajpaapp.entity.Course;
import com.scotycodebuffer.springdatajpaapp.entity.Student;
import com.scotycodebuffer.springdatajpaapp.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){ // visalble when add mappedby -- bidirectional
        List<Course> courses = courseRepository.findAll();

        System.out.println("coures "+ courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Kali")
                .lastName("Kante")
                .build();

        //CourseMaterial courseMaterial=
        //        CourseMaterial.builder()
        //                .course("")

        // opcja dotycząca many to one czyli do kursu dopisujemy nauczyciela
        // i rezygnujemy z kolekcji listy wiec potrzeba wykomentowac poprzedni test
        // jesli relacja jest zrealizowana w klasie Course to zapis odbywa sie przy pomocy
        // courseRepository, w przeciwnym wypadku teacherRepository
        Course course = Course.builder()
                .tittle("Spring and React")
                .credit(25)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
//// stronnicowanie
   @Test
   public void findAllPagination(){
       Pageable firstpageWithThreeRec = PageRequest.of(0,3);
       Pageable secpageWithTwoRec = PageRequest.of(1,2 );

       List<Course> courses =
               courseRepository.findAll(secpageWithTwoRec)
                       .getContent();

       // zlicza wszytskie kusry w bazie
       Long totalElements =
               courseRepository.findAll(secpageWithTwoRec)
                               .getTotalElements();
       // zlicza wszytskie strony daltego 2 poniewaz PageRequest,
       // przyjmuje 3 elementy(size) na jedną strone a łącznie jest ich 5 aktualnie.
       //dla firstpageWithThreeRec
       // secpageWithTwoRec totalEl 5, totalPag 3
       int totalPages =
               courseRepository.findAll(secpageWithTwoRec)
                               .getTotalPages();
       System.out.println("totalElements " + totalElements);
       System.out.println("totalPages " + totalPages);
       System.out.println("courses " + courses);

   }
/// znajdowanie i sortowanie
   @Test
   public void findAllSorting(){
        Pageable sortByTittle =
                PageRequest.of(0,2,
                        Sort.by("tittle"));

        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );
        Pageable sortByTittleAndCreditDesc=
                PageRequest.of(
                        0,
                        2,
                        Sort.by("tittle")
                                .descending()
                                .and(Sort.by("credit"))
                );
       List<Course> courses =
               courseRepository.findAll(sortByTittle).getContent();
       //get content wyciąga liste, bez getContent() mamy obiekt typu Page
       System.out.println("corses sorted by propertis "+courses);
   }
//znajdowanie zawierających Literę
   @Test
   public void printByTittleContaingnig(){
       Pageable firstPageTenRecords =
               PageRequest.of(0,10);

       List<Course> courses =
               courseRepository.findByTittleContaining(
                       "R",
                       firstPageTenRecords).getContent();
       System.out.println("courses = " + courses);

   }

    @Test
    public void findCoursesFillteringByCredit(){
        List<Course> byCreditIsLessThan = courseRepository.findByCreditIsLessThan(60);

       // List<Course> sortedAscendingAfterFillter = byCreditIsLessThan.stream()
       //       .sorted((o1, o2) -> o1.getCredit().compareTo(o2.getCredit()))
       //       .collect(Collectors.toList());

        List<Course> sortedDescendingAfterFillter = byCreditIsLessThan.stream()
                .sorted(Comparator.comparingInt(Course::getCredit).reversed().thenComparing(Course::getTittle))
                .collect(Collectors.toList());


        Long totalElements = courseRepository.findByCreditIsLessThan(60).stream().count();
        System.out.println("totalElements = " + totalElements);
        System.out.println("byCreditIsLessThan = " + byCreditIsLessThan);
        System.out.println("sortedLessThanSixty = " + sortedDescendingAfterFillter);
  }
    @Test
    public void filteringFindingAndSortig(){
        List<Course> filter_and_sorting = courseRepository.findByTittleOrderByCreditDesc("Spring and React");
        System.out.println("filter_and_sorting = " + filter_and_sorting);
    }
    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Mateusz")
                .lastName("Borek")
                .build();

        Student student = Student.builder()
                .firstName("Myaki")
                .lastName("Langlet")
                .emailId("langlet@gmail.com")
                .build();

        Course course = Course.builder()
                .tittle("React Hooks")
                .credit(100)
                .teacher(teacher)
                .build();

        course.addStudents(student); // wyskorzstanie metody z encji kursu w celu przetestowania relacji ManyToMany
        courseRepository.save(course);

    }




}