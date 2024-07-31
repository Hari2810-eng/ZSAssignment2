/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author priya
 */
public class LibraryDatabase {
    private List<Book> listOfBooks = new ArrayList<>();
    private List<Account> listOfAccounts = new ArrayList<>();
    
    public LibraryDatabase(List<Book> books) {
        this.listOfBooks = books != null ? books : new ArrayList<>(); 
    }
    
    public void addBook(Book book) {
        listOfBooks.add(book);
    }

    public void deleteBook(Book book) {
        listOfBooks.remove(book);
    }

    public void updateBook(Book oldBook, Book newBook) {
        int index = listOfBooks.indexOf(oldBook);
        if (index != -1) {
            listOfBooks.set(index, newBook);
        }
    }

    public void displayBooks() {
        for (Book book : listOfBooks) {
            System.out.println(book.getTitle());
        }
    }

    public Book searchBook(String searchString) {
        for (Book book : listOfBooks) {
            if (book.getTitle().equalsIgnoreCase(searchString)) {
                return book;
            }
        }
        return null;
    }

    public void addAccount(Account account) {
        listOfAccounts.add(account);
    }

    public void deleteAccount(Account account) {
        listOfAccounts.remove(account);
    }

    public void updateAccount(Account oldAccount, Account newAccount) {
        int index = listOfAccounts.indexOf(oldAccount);
        if (index != -1) {
            listOfAccounts.set(index, newAccount);
        }
    }

    public void displayAccounts() {
        for (Account account : listOfAccounts) {
            System.out.println("Account with " + account.getNoBorrowedBooks() + " borrowed books");
        }
    }

    public Account searchAccount(int accountId) {
        for (Account account : listOfAccounts) {
            if (account.getId() == accountId) {
                return account;
            }
        }
        return null;
    }
}
