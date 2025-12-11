package com.example.employmee.service;

import com.example.employmee.dto.EmployeeDto;
import com.example.employmee.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    public EmployeeEntity addEmployee(EmployeeDto dto);
    List<EmployeeEntity> getAllEmployees();
    EmployeeEntity getEmployeeById(int id);
    List<EmployeeEntity> getEmployeeByName(String firstName);
    EmployeeEntity updateEmployee(int id, EmployeeEntity updatedEmployee);
    EmployeeEntity updateEmployeeByName(String firstName, EmployeeEntity updatedEmployee);
    boolean deleteByEmployeeId(int id);
    boolean deleteByEmployeeName(String firstName);
}
