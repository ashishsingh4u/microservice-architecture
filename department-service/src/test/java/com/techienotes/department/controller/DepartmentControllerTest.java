package com.techienotes.department.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techienotes.department.entity.Department;
import com.techienotes.department.repository.DepartmentRepository;
import com.techienotes.department.service.DepartmentService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.aMapWithSize;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DepartmentControllerTest {

    @SpyBean
    DepartmentController departmentController;

    @SpyBean
    DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;

    @Autowired
    MockMvc mockMvc;

    static String asJson(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }

    @Test
    void saveDepartment() throws Exception {
        Department department = new Department(1L, "ADMIN", "TTC", "AD-100");

        mockMvc.perform(MockMvcRequestBuilders.post("/departments/")
                        .content(asJson(department))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(departmentController, times(1)).saveDepartment(department);
        verify(departmentService, times(1)).saveDepartment(department);
        verify(departmentRepository, times(1)).save(department);
    }

    @Test
    void findDepartmentById() throws Exception {
        Department department = new Department(1L, "ADMIN", "TTC", "AD-100");
        doReturn(department).when(departmentRepository).findByDepartmentId(1L);
        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", aMapWithSize(4)))
                .andExpect(jsonPath("$.departmentId", Matchers.is(1)))
                .andExpect(jsonPath("$.departmentName", Matchers.is("ADMIN")))
                .andExpect(jsonPath("$.departmentAddress", Matchers.is("TTC")))
                .andExpect(jsonPath("$.departmentCode", Matchers.is("AD-100")));

        verify(departmentController, times(1)).findDepartmentById(1L);
        verify(departmentService, times(1)).findDepartmentById(1L);
        verify(departmentRepository, times(1)).findByDepartmentId(1L);
    }
}