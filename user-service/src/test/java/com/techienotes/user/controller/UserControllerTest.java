package com.techienotes.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techienotes.user.entity.User;
import com.techienotes.user.repository.UserRepository;
import com.techienotes.user.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @SpyBean
    UserController userController;

    @SpyBean
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testUserControllerSave() throws Exception {
        User user = new User(1L, "Test", "Method", "Test@Method.com", "1");
        mockMvc.perform(MockMvcRequestBuilders.post("/users/")
                        .content(asJson(user))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userController, times(1)).saveUser(user);
        verify(userService, times(1)).saveUser(user);
        verify(userRepository, times(1)).save(user);
    }

    @Disabled("Failing with Load-balancer dependency as department service is not up during test")
    void givenUsers_whenFindUsers_thenStatus200() throws Exception {
        User user = new User(1L, "Test", "Method", "Test@Method.com", "1");
        doReturn(user).when(userRepository).findByUserId(1L);
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    String asJson(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }
}