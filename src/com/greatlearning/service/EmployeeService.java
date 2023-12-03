package com.greatlearning.service;

import com.greatlearning.model.Employee;

public interface EmployeeService {
    String generateEmailId(String firstName, String lastName, String deptName);

    String generatePassword();

    void showEmployeeDetails(Employee employee);
}
