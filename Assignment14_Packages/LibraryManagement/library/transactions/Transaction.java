package library.transactions;

import library.books.Book;
import library.members.Member;

import java.time.LocalDate;

public class Transaction {
    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Transaction(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.returnDate = null;
    }

    public void processTransaction(boolean isReturning) {
        if (isReturning) {
            this.returnDate = LocalDate.now();
            this.book.setAvailable(true);
            System.out.println("Book returned: " + book.getTitle());
        } else {
            if (book.isAvailable()) {
                this.book.setAvailable(false);
                this.borrowDate = LocalDate.now();
                System.out.println("Book borrowed: " + book.getTitle());
            } else {
                System.out.println("Book is not available for borrowing: " + book.getTitle());
            }
        }
    }

    @Override
    public String toString() {
        return "Transaction [Book: " + book + ", Member: " + member + ", Borrow Date: " + borrowDate + ", Return Date: " + returnDate + "]";
    }
}
