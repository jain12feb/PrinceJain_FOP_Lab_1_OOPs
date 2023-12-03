package com.greatlearning.service;

import com.greatlearning.model.Employee;

import java.util.Random;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public String generateEmailId(String firstName, String lastName, String deptName) {
        return firstName + lastName + "@" + deptName + "." + "greatlearning.com";
    }

    @Override
    public String generatePassword() {
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()";

        String combined = caps + lower + numbers + specialChars;
        String password = "";

        Random random = new Random();

        for (int i = 0; i <= 8; i++) {
            password += String.valueOf(combined.charAt(random.nextInt(combined.length())));
        }

        return password;
    }

    @Override
    public void showEmployeeDetails(Employee employee) {
        System.out.println("\nFirst Name : " + employee.getFirstName() + "\n" +
                "Last Name : " + employee.getLastName() + "\n" +
                "Email Id : " + employee.getEmail() + "\n" +
                "Password : " + employee.getPassword());

    }
}
