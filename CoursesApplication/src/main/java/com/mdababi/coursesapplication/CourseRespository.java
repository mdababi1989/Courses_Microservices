package com.mdababi.coursesapplication;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CourseRespository extends JpaRepository<Course, BigInteger> {
}
