package com.mdababi.coursesapplication;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@RestController
public class CourseController {
    private CourseRespository courseRespository;

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseRespository.findAll();
    }

    @GetMapping("/{id}")
    public Course getSpecificCourse(@PathVariable("id") BigInteger id){
        return courseRespository.findById(id).orElse(null);
    }

    @PostMapping("/courses")
    public Course saveCourse(Course course){
        return courseRespository.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse (@PathVariable("id") BigInteger id){
        courseRespository.deleteById(id);
    }





}
