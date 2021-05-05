package com.mdababi.userapplication;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private UserRepository userRepository;

    @GetMapping("/")
    private List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    private User findUser(@PathVariable("id")BigInteger id){
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/course/{id}")
    private List<User> findUsersForCourse(@PathVariable("id")BigInteger id){
        return userRepository.findByCourseId(id);
    }


}
