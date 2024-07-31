/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lms;

import java.util.List;
/**
 *
 * @author priya
 */
public class User {
    private String name;
    private int id;
    private Account account;
    private List<Book> borrowedBooks;
    
    public User(String name, int id) {
        this.name = name;
        this.id = id;
        this.account = new Account();
    }
    
    public boolean verify(){
        return true;
    }
    public Account checkAccount(){
        return account;
    }
    public Book getBookInfo(String title) {
        for (Book book : borrowedBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}

class Staff extends User {
    private String dept;

    public Staff(String name, int id, String dept) {
        super(name, id);
        this.dept = dept;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}

class Student extends User {
    private String className;

    public Student(String name, int id, String className) {
        super(name, id);
        this.className = className;
    }

    // Getter and Setter
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}