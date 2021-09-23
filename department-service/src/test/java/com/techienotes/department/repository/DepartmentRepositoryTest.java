package com.techienotes.department.repository;

import com.techienotes.department.entity.Department;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department1 = new Department(1L, "ADMIN", "TTC", "AD-100");
        departmentRepository.save(department1);
        Department department2 = new Department(2L, "FINANCE", "TTC", "AD-101");
        departmentRepository.save(department2);
        Department department3 = new Department(3L, "IT", "TTC", "AD-102");
        departmentRepository.save(department3);
        Department department4 = new Department(4L, "MANAGEMENT", "TTC", "AD-103");
        departmentRepository.save(department4);
        Department department5 = new Department(5L, "INFRA", "TTC", "AD-104");
        departmentRepository.save(department5);
    }

    @AfterEach
    void cleanUp() {
        departmentRepository.deleteAll();
    }

    @Test
    void testFindByUserId() {
        Department department = departmentRepository.findByDepartmentId(1L);
        assertEquals(1L, department.getDepartmentId(), "DepartmentId is not same");
    }
}