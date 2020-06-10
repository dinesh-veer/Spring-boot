package com.springBoot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee	, Long> {

}
