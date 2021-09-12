package com.techienotes.department.service;

import com.techienotes.department.entity.Department;
import com.techienotes.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside Save department of Service");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside find department of Service");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
