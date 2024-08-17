class CustomException extends Exception {
    public CustomException(String message){
        super(message);
    }
}

public class CustomExceptionDemo {
    public static void main(String args[]){
        try{
            checkValue(5);
        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Program continues after handling the custom exception.");
    }
    
    public static void checkValue(int value) throws CustomException {
        if (value < 18) {
            throw new CustomException("Not valid to get driving License");
        } else {
            System.out.println("Valid to apply for driving license");
        }
    }
}
