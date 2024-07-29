/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment9_constructor;

/**
 *
 * @author priya
 */
public class Employee {
    private String name;
    private String employeeId;
    private String department;
    private double salary;
    private int age;
    private String ssn; 

    private static final String DEFAULT_DEPARTMENT = "Unknown";

    // Parameterized constructor
    public Employee(String name, String employeeId, String department, double salary, int age, String ssn) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public static String getDefaultDepartment() {
        return DEFAULT_DEPARTMENT;
    }

    public String getEmployeeDetails() {
        return "Employee Details:\n" +
               "Name: " + name + "\n" +
               "Employee ID: " + employeeId + "\n" +
               "Department: " + department + "\n" +
               "Salary: " + salary + "\n" +
               "Age: " + age + "\n" +
               "SSN: [Protected]"; 
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("John Doe", "E12345", "Engineering", 75000.00, 30, "123-45-6789");
        employees[1] = new Employee("Jane Smith", "E67890", "Marketing", 65000.00, 28, "987-65-4321");
        employees[2] = new Employee("Bob Johnson", "E54321", "Sales", 70000.00, 35, "567-89-0123");

        for (Employee employee : employees) {
            System.out.println(employee.getEmployeeDetails());
            System.out.println();
        }
    }
}