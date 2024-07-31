/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lms;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author priya
 */
public class LMS {
     private String userType;
    private String userName;
    private String password;

    private List<User> users;
    private List<Book> books;
    private Librarian librarian;
    private LibraryDatabase libraryDatabase;

    public LMS(Librarian librarian, List<User> users, List<Book> books, LibraryDatabase libraryDatabase) {
        this.librarian = librarian;
        this.users = users != null ? users : new ArrayList<>(); // Avoid null
        this.books = books != null ? books : new ArrayList<>(); // Avoid null
        this.libraryDatabase = libraryDatabase != null ? libraryDatabase : new LibraryDatabase(this.books);
    }

    public String login() {
        return "Login successful";
    }

    public String register() {
        return "Registration successful";
    }

    public String logout() {
        return "Logout successful";
    }

    public static void main(String[] args) {
        
        List<User> users = new ArrayList<>();
        User student = new Student("user1", 98, "BE. C");
        User staff = new Staff("staff1", 97, "CSE");
        users.add(student);
        users.add(staff);

        List<Book> books = new ArrayList<>();
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", "1925");
        Book book2 = new Book("1984", "George Orwell", "987654321", "1949");
        books.add(book1);
        books.add(book2);

        LibraryDatabase libraryDatabase = new LibraryDatabase(books);
        Librarian librarian = new Librarian("aadhavan", 123, "123", libraryDatabase);
        
        LMS lms = new LMS(librarian, users, books, libraryDatabase);

        lms.register();
        lms.login();

        for (Book book : lms.books) {
            System.out.println(book.getTitle());
        }

        lms.logout();
    }
}
