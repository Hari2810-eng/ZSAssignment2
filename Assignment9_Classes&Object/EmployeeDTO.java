/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment8_classesobject;

/**
 * 2. Create an Employee DTO class. Create appropriate instance variables, static variables and methods with appropriate access modifiers.
 * Maintain encapsulation by giving controlled access to employee's PII.
 * @author priya
 */
public class EmployeeDTO {
    private String name;
    private String employeeId;
    private String department;
    private double salary;
    private int age;
    private String ssn; 

    private static final String DEFAULT_DEPARTMENT = "Unknown";

    public EmployeeDTO() {
        this.department = DEFAULT_DEPARTMENT;
    }

    public EmployeeDTO(String name, String employeeId, String department, double salary, int age, String ssn) {
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

    /*public String getSsn() {
        return ssn;
    }*/
    //so setter to make SSN protected information
    public String getLastFourDigitsOfSsn() {
        if (ssn != null && ssn.length() >= 4) {
            return ssn.substring(ssn.length() - 4);
        }
        return "N/A";
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
               "SSN: [Protected]( last 4 digit)"+ getLastFourDigitsOfSsn();
    }

    public static void main(String[] args) {
        EmployeeDTO employee = new EmployeeDTO("John", "E12345", "Engineering", 75000.00, 30, "123-45-6789");
        System.out.println(employee.getEmployeeDetails());
    }
}
