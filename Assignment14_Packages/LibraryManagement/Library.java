import library.books.Book;
import library.members.Member;
import library.transactions.Transaction;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");

        Member member1 = new Member("Alice Smith", "M001");

        // Borrow a book
        Transaction transaction1 = new Transaction(book1, member1);
        transaction1.processTransaction(false); // Borrowing

        // Attempt to borrow the same book again
        transaction1.processTransaction(false); // Should indicate the book is not available

        // Return the book
        transaction1.processTransaction(true); // Returning

        transaction1.processTransaction(false); 
    }
}
