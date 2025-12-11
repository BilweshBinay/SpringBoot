package com.example.employmee.controller;

import com.example.employmee.dto.EmployeeDto;
import com.example.employmee.entity.EmployeeEntity;
import com.example.employmee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")

public class EmployeeController {
    @Autowired
    EmployeeService service;

    @PostMapping("/save")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDto dto) {
        service.addEmployee(dto);
        return ResponseEntity.ok("Employee added successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable int id) {
        EmployeeEntity employee = service.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/name/{firstName}")
    public ResponseEntity<?> getByFirstName(@PathVariable String firstName) {
        List<EmployeeEntity> employees = service.getEmployeeByName(firstName);

        if (employees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee First Name not found: " + firstName);
        }

        return ResponseEntity.ok(employees);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable int id,
            @RequestBody EmployeeEntity updatedEmployee) {

        EmployeeEntity employee = service.updateEmployee(id, updatedEmployee);

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee with ID " + id + " not found");
        }

        return ResponseEntity.ok(employee);
    }

    @PutMapping("/updatechar/{firstName}")
    public ResponseEntity<?> updateEmployeeByName(@PathVariable String firstName,
                                                  @RequestBody EmployeeEntity updatedEmployee) {
        EmployeeEntity employee = service.updateEmployeeByName(firstName, updatedEmployee);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee Name not found: "+firstName);
        }
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        boolean delete = service.deleteByEmployeeId(id);

        if(!delete) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee ID " +id + " not found");
        }
        return ResponseEntity.ok("Employee deleted successfully");
    }

    @DeleteMapping("/deleteByName/{firstName}")
    public ResponseEntity<?> deleteByName (@PathVariable String firstName) {
        boolean delete = service.deleteByEmployeeName(firstName);

        if (!delete) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee Name "+firstName+" not found");
        }
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
