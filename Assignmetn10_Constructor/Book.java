/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment9_constructor;
/**
 * Book Data Transfer Object (DTO) class.
 * Represents a book with its attributes.
 * Provides methods to manage the book's information.
 * 
 * Author: Priya
 */

public class Book {
    private String title;
    private String author;
    private String publisher;
    private double price;
    private int yearPublished;

    public Book(String title, String author, String publisher, double price, int yearPublished) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getBookDetails() {
        return "Book Details:\n" +
               "Title: " + title + "\n" +
               "Author: " + author + "\n" +
               "Publisher: " + publisher + "\n" +
               "Price: " + price + "\n" +
               "Year Published: " + yearPublished;
    }

    public static void main(String[] args) {
        Book[] books = new Book[3];
        books[0] = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Scribner", 10.99, 1925);
        books[1] = new Book("1984", "George Orwell", "Secker & Warburg", 15.99, 1949);
        books[2] = new Book("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 12.99, 1960);

        for (Book book : books) {
            System.out.println(book.getBookDetails());
            System.out.println();
        }
    }
}
