package com.example.employmee.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class EmployeeDto {
    private int empId;
    private String firstName;
    private String email;
    private double salary;
    private String department;
}
