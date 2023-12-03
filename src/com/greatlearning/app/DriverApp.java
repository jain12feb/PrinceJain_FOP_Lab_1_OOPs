package com.greatlearning.app;

import com.greatlearning.model.Employee;
import com.greatlearning.service.EmployeeService;
import com.greatlearning.service.EmployeeServiceImpl;

import java.util.Scanner;

public class DriverApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your first name");
        String firstName = sc.next().toLowerCase();
        System.out.println("Please enter your last name");
        String lastName = sc.next().toLowerCase();

        System.out.println("Please choose Department");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resource");
        System.out.println("4. Legal");

        int choice = sc.nextInt();

        EmployeeService employeeService = new EmployeeServiceImpl();

        String generatedEmail = null;
        String generatedPassword;

        switch (choice) {
            case 1:
                generatedEmail = employeeService.generateEmailId(firstName, lastName, "tech");
                break;
            case 2:
                generatedEmail = employeeService.generateEmailId(firstName, lastName, "admin");
                break;
            case 3:
                generatedEmail = employeeService.generateEmailId(firstName, lastName, "hr");
                break;
            case 4:
                generatedEmail = employeeService.generateEmailId(firstName, lastName, "legal");
                break;
            default:
                System.out.println("Please enter valid choice");
        }
        generatedPassword = employeeService.generatePassword();

        if (generatedPassword != null && generatedEmail != null) {
            Employee employee = new Employee();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(generatedEmail);
            employee.setPassword(generatedPassword);

            employeeService.showEmployeeDetails(employee);

        } else {
            System.out.println("Something Went Wrong");
        }

        sc.close();
    }
}
