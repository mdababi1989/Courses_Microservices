package com.mdababi.coursesapplication;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {
    private final CourseRespository courseRespository;

    @Override
    public void run(ApplicationArguments args) {
        if (courseRespository.findAll().size() == 0)
            for (int i = 0; i < 10; i++)
                courseRespository.save(new Course("course" + i, "author" + i));
    }
}
