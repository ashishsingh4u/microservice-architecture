package com.techienotes.user.repository;

import com.techienotes.user.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        User user1 = new User(1L, "Test1", "Method", "Test1@Method.com", "1");
        userRepository.save(user1);
        User user2 = new User(2L, "Test2", "Method", "Test2@Method.com", "1");
        userRepository.save(user2);
        User user3 = new User(3L, "Test3", "Method", "Test3@Method.com", "1");
        userRepository.save(user3);
        User user4 = new User(4L, "Test4", "Method", "Test4@Method.com", "1");
        userRepository.save(user4);
        User user5 = new User(5L, "Test5", "Method", "Test5@Method.com", "1");
        userRepository.save(user5);
    }

    @AfterEach
    void cleanUp() {
        userRepository.deleteAll();
    }

    @Test
    void testFindByUserId() {
        User user = userRepository.findByUserId(1L);
        Assertions.assertEquals(1L, user.getUserId(), "UserId is not same");
    }

}