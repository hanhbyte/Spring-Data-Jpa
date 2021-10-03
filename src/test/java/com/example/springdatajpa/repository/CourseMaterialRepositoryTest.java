package com.example.springdatajpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.springdatajpa.entity.Course;
import com.example.springdatajpa.entity.CourseMetarial;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseMaterialRepositoryTest {

  @Autowired
  private CourseMaterialRepository repository;

  @Test
  public void SaveCourseMaterial() {
    Course course =
        Course.builder()
            .title(".net")
            .credit(6)
            .build();

    CourseMetarial courseMetarial =
        CourseMetarial.builder()
            .url("https://www.facebook.com/")
            .course(course)
            .build();
    repository.save(courseMetarial);
  }

  @Test
  public void printAllCourseMaterial(){
    List<CourseMetarial> courseMetarials = repository.findAll();
    System.out.println("courseMaterial ="+courseMetarials);
  }
}