/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment8_classesobject;

/**
 * 1. Create Book DTO class with attributes like title, ISBN etc. 
 * Create appropriate instance variables, static variables and methods with appropriate access modifiers.
 * @author priya
 */

import java.util.*;

public class BookDTO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<BookDTO> books = new ArrayList<>();
        Set<String> isbnSet = new HashSet<>();

        System.out.print("Enter the number of books you want to enter: ");
        int bookno = scanner.nextInt();
        scanner.nextLine(); 
        
        for (int i = 0; i < bookno; i++) {
            System.out.println("\nBook " + (i + 1) + " details:");

            BookDTO book = new BookDTO();

            System.out.print("Enter the title of the book: ");
            book.setTitle(scanner.nextLine());
            
            String isbn;
            while (true) {
                System.out.print("Enter the ISBN of the book: ");
                isbn = scanner.nextLine();
                if (isbnSet.contains(isbn)) {
                    System.out.println("ISBN already exists. Please enter a unique ISBN.");
                } else {
                    isbnSet.add(isbn);
                    book.setIsbn(isbn);
                    break;
                }
            }
            
            
            System.out.print("Enter the author of the book: ");
            book.setAuthor(scanner.nextLine());
            
            System.out.print("Enter the price of the book: ");
            book.setPrice(scanner.nextDouble());
            scanner.nextLine();
            
            System.out.print("Enter the publication year of the book: ");
            book.setPublicationYear(scanner.nextInt());
            scanner.nextLine();
            
            System.out.print("Enter the rating of the book (out of 5): ");
            book.setRating(scanner.nextDouble());
            scanner.nextLine();
            
            books.add(book);
        }


        for (int i = 0; i < books.size(); i++) {
            System.out.print("\n\n----Details of book " + (i + 1) + "----");
            System.out.println(books.get(i).details());
            System.out.print("-------------------------");
        }
    }

    private String title;
    private String author;
    private String isbn;
    private double price;
    private int publicationYear;
    private double rating;

    private static final String DEFAULT_PUBLISH = "Unknown";

    public BookDTO() {}

    public BookDTO(String title, String author, String isbn, double price, int publicationYear, double rating) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.publicationYear = publicationYear;
        this.rating = rating;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public static String getDefaultPublish() {
        return DEFAULT_PUBLISH;
    }

    public String details() {
        return "\nTitle: " + title +
               "\nAuthor: " + author +
               "\nIsbn: " + isbn +
               "\nPrice: " + price +
               "\nPublicationYear: " + publicationYear +
               "\nRating: " + rating;
    }
}
