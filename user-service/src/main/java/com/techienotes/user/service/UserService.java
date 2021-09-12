package com.techienotes.user.service;

import com.techienotes.user.entity.User;
import com.techienotes.user.model.Department;
import com.techienotes.user.model.ResponseData;
import com.techienotes.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside save user of Service");
        return userRepository.save(user);
    }

    public ResponseData getUserWithDepartment(Long userId) {
        log.info("Inside get user of Service");
        ResponseData data = new ResponseData();

        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject(String.format("http://DEPARTMENT-SERVICE/departments/%s",
                user.getDepartmentId()), Department.class);

        data.setUser(user);
        data.setDepartment(department);
        return data;
    }
}
