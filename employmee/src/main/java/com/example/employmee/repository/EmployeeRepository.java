package com.example.employmee.repository;

import com.example.employmee.entity.EmployeeEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    List<EmployeeEntity> getByFirstName(String firstName);
    boolean existsByFirstName(String firstName);
}
