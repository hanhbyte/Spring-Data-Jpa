package com.example.springdatajpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.springdatajpa.entity.Course;
import com.example.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {

  @Autowired
  private TeacherRepository teacherRepository;

  @Test
  public void saveTeacher(){
    Course courseDB =   Course.builder()
        .title("DB")
        .credit(5)
        .build();

    Course courseJAVA = Course.builder()
        .title("Java")
        .credit(6)
        .build();

    Teacher teacher = Teacher.builder()
        .firstName("Hanh")
        .lastName("Nguyen")
        .build();

    teacherRepository.save(teacher);
  }
}