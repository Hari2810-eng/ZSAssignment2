/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment10_inheritance;

/**
 * 2. Design a Student Parent class and ZSGSStudent Child class. 
 * Create constructors in both class with varying number of parameters. Call parent constructor from child constructor. 
 * Try experimenting by creating child object using parent constructor.
 * @author priya
 */
class Student {
    private String name;
    private int age;
    private String address;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.address = "Unknown";
    }
    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}

public class ZSGSStudent extends Student{
    private String studentId;
    private String course;

    public ZSGSStudent(String name, int age, String studentId, String course) {
        super(name, age); 
        this.studentId = studentId;
        this.course = course;
    }

    public ZSGSStudent(String name, int age, String address, String studentId, String course) {
        super(name, age, address);  
        this.studentId = studentId;
        this.course = course;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();  // Calling parent method
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
    }

    public static void main(String[] args) {
        Student student = new ZSGSStudent("John Doe", 20, "1234", "Computer Science");
        student.displayDetails();

        System.out.println();

        // Creating a ZSGSStudent object using the child constructor with address
        ZSGSStudent zsgsStudent = new ZSGSStudent("Jane Doe", 22, "123 Main St", "5678", "Electrical Engineering");
        zsgsStudent.displayDetails();
    }
}
