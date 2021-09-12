package com.techienotes.user.controller;

import com.techienotes.user.entity.User;
import com.techienotes.user.model.ResponseData;
import com.techienotes.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside save user of Controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseData getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside get user of Controller");
        return userService.getUserWithDepartment(userId);
    }


}
