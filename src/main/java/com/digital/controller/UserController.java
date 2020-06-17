package com.digital.controller;

import com.digital.entity.User;
import com.digital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        // 存在则返回，不存在返回null
        User one = userRepository.findById(id).orElse(null);
        System.out.println("one = " + one);
        return one;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        return userRepository.save(user);
    }
}
