/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lms;

/**
 *
 * @author priya
 */
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private String publication;

    public Book() {
    }

    public Book(String title, String author, String ISBN, String publication) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publication = publication;
    }

    public String getTitle() {
        return title;
    }

    public void showDueDate() {
    }

    public String reservationStatus() {
        return "Reserved";
    }

    public void feedback(String feedback) {
    }

    public void bookRequest() {
    }

    public void renewInfo() {
    }
}
