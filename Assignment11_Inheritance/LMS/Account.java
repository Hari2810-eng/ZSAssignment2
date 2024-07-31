/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lms;

/**
 *
 * @author priya
 */
public class Account {
    private int id;
    private int noBorrowedBooks;
    private int noReservedBooks;
    private int noReturnedBooks;
    private int noLostBooks;
    private double fineAmount;
    
    public Account() {
    }
    
    public Account(int id, int noBorrowedBooks, int noReservedBooks, int noReturnedBooks, int noLostBooks, double fineAmount) {
        this.id = id;
        this.noBorrowedBooks = noBorrowedBooks;
        this.noReservedBooks = noReservedBooks;
        this.noReturnedBooks = noReturnedBooks;
        this.noLostBooks = noLostBooks;
        this.fineAmount = fineAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoBorrowedBooks() {
        return noBorrowedBooks;
    }

    public void setNoBorrowedBooks(int noBorrowedBooks) {
        this.noBorrowedBooks = noBorrowedBooks;
    }

    public int getNoReservedBooks() {
        return noReservedBooks;
    }

    public void setNoReservedBooks(int noReservedBooks) {
        this.noReservedBooks = noReservedBooks;
    }

    public int getNoReturnedBooks() {
        return noReturnedBooks;
    }

    public void setNoReturnedBooks(int noReturnedBooks) {
        this.noReturnedBooks = noReturnedBooks;
    }

    public int getNoLostBooks() {
        return noLostBooks;
    }

    public void setNoLostBooks(int noLostBooks) {
        this.noLostBooks = noLostBooks;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public double calculateFine() {
        return fineAmount;
    }
}
