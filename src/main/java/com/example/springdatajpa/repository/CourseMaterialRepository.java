package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.CourseMetarial;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseMaterialRepository extends JpaRepository<CourseMetarial, Long> {

}
