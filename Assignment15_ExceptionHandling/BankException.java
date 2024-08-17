class InsufficientFundsException extends Exception{
    InsufficientFundsException (String message){
        super(message);
    }
}

class BankAccount{

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withDraw(double amount) throws InsufficientFundsException {
        if(amount > balance)
            throw new InsufficientFundsException("Insuffient funds for withdrawal.");
        else {
            balance -= amount;
            System.out.println("Successful withdrawal. Remaining Balance: "+balance);
        }
    }
}
public class BankException {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(10000);
        try{
            acc.withDraw(15000);
            
        } catch (InsufficientFundsException e) {
            System.out.println("Error: "  + e.getMessage());
        }
    }
}
