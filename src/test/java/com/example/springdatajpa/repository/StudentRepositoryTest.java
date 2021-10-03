package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Guardian;
import com.example.springdatajpa.entity.Student;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

  @Autowired
  private StudentRepository studentRepository;

  @Test
  public void saveStudent(){
    Student student = Student.builder()
        .emailId("hanh@gmail.com")
        .firstName("Hanh")
        .lastName("Nguyen")
//        .guardianEmail("MyNhat")
//        .guardianEmail("mynhat@gmail.com")
//        .guardianMobile("999999999")
        .build();

    studentRepository.save(student);
  }

  @Test
  public void saveStudentWithGuardian(){
    Guardian guardian = Guardian.builder()
        .email("nhat@gmail.com")
        .name("Nhat")
        .mobile("999888777")
        .build();

    Student student = Student.builder()
        .firstName("Nam")
        .emailId("nam@gmail.com")
        .lastName("Nguyen")
        .guardian(guardian)
        .build();

    studentRepository.save(student);
  }

  @Test
  public void printAllStudent(){
    List<Student> studentList = studentRepository.findAll();
    System.out.println("StudentList = "+studentList);
  }

  @Test
  public void printStudentByFirstName(){
    List<Student> students = studentRepository.findByFirstName("nam");
    System.out.println("student ="+students);
  }

  @Test
  public void printStudentByFirstNameContaining(){
    List<Student> students = studentRepository.findByFirstNameContaining("na");
    System.out.println("students ="+students);
  }

  @Test
  public void printStudentBasedOnGuardianName(){
    List<Student> students = studentRepository.findByGuardianName("Nhat");
    System.out.println("students = "+students);
  }

  @Test
  public void  printgetStudentByEmailAddress(){
    Student student = studentRepository.getStudentByEmailAddress("hanh@gmail.com");
    System.out.println("student = "+student);
  }

  @Test
  public void printgetStudentFirstNameByEmailAddress(){
    String firstName = studentRepository.getStudentFirstNameByEmailAddress("nam@gmail.com");
    System.out.println("firstname ="+firstName);
  }

  @Test
  public void printgetStudentByEmailAddressNative(){
    Student student = studentRepository.getStudentByEmailAddressNative("nam@gmail.com");
    System.out.println("student ="+student);
  }

  @Test
  public void printgetStudentByEmailAddressNativeNamParam(){
    Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("nam@gmail.com");
    System.out.println("student ="+student);
  }

  @Test
  public void updateStudentNamByEmailIdTest(){
    studentRepository.updateStudentNameByEmailId(
        "hanh nguyen",
        "hanh@gmail.com"
    );
  }
}