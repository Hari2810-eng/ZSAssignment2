/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment10_inheritance;

/**
 *
 * @author priya
 */



class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public double area() {
        return 0.0;
    }

    public double perimeter() {
        return 0.0;
    }

    public String getColor() {
        return color;
    }

    public void displayShapeDetails() {
        System.out.println("Shape color: " + color);
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void displayShapeDetails() {
        super.displayShapeDetails();
        System.out.println("Radius: " + radius);
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public void displayShapeDetails() {
        super.displayShapeDetails();
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape circle = new Circle("Red", 5);
        Shape rectangle = new Rectangle("Blue", 4, 6);

        circle.displayShapeDetails();
        System.out.println();

        rectangle.displayShapeDetails();
    }
}
