package com.example.employmee.service;

import com.example.employmee.dto.EmployeeDto;
import com.example.employmee.entity.EmployeeEntity;
import com.example.employmee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository repository;

    @Override
    public EmployeeEntity addEmployee(EmployeeDto dto) {
        EmployeeEntity employee = new EmployeeEntity();
        BeanUtils.copyProperties(dto, employee);
        return repository.save(employee);
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public EmployeeEntity getEmployeeById(int id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public List<EmployeeEntity> getEmployeeByName(String firstName) {
        return repository.getByFirstName(firstName);
    }

    @Override
    public EmployeeEntity updateEmployee(int id, EmployeeEntity updatedEmployee) {
        return repository.findById(id).map(existingEmployee -> {
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());

            return repository.save(existingEmployee);
        }).orElse(null);
    }

    @Override
    public EmployeeEntity updateEmployeeByName(String firstName, EmployeeEntity updatedEmployee) {
        return repository.getByFirstName(firstName).stream().map(existingEmployee -> {
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());

            return  repository.save(existingEmployee);
        }).findAny().orElse(null);
    }

    @Override
    public boolean deleteByEmployeeId(int id) {
        if(!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteByEmployeeName(String firstName) {
        if (!repository.existsByFirstName(firstName)) {
            return false;
        }
        repository.existsByFirstName(firstName);
        return true;
    }
}
