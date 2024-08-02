
import java.util.*;

abstract class Product {
    protected String name;

    public Product(String name) {
        this.name = name;
    }

    public abstract double getPrice();
    public abstract String getDescription();

    public String getName() {
        return name;
    }
}

class ElectronicsProduct extends Product {
    private double price;
    private String brand;

    public ElectronicsProduct(String name, double price, String brand) {
        super(name);
        this.price = price;
        this.brand = brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Electronics Product: " + name + ", Brand: " + brand;
    }
}

class ClothingProduct extends Product {
    private double price;
    private String size;

    public ClothingProduct(String name, double price, String size) {
        super(name);
        this.price = price;
        this.size = size;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Clothing Product: " + name + ", Size: " + size;
    }
}

class BookProduct extends Product {
    private double price;
    private String author;

    public BookProduct(String name, double price, String author) {
        super(name);
        this.price = price;
        this.author = author;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Book: " + name + ", Author: " + author;
    }
}

class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void displayCartDetails() {
        for (Product product : products) {
            System.out.println(product.getDescription() + " | Price: $" + product.getPrice());
        }
        System.out.println("Total Price: $" + calculateTotalPrice());
    }
}


public class ShoppingCartDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Product laptop = new ElectronicsProduct("Laptop", 999.99, "Dell");
        Product tshirt = new ClothingProduct("T-Shirt", 19.99, "M");
        Product book = new BookProduct("The Alchemist", 12.99, "Paulo Coelho");

        cart.addProduct(laptop);
        cart.addProduct(tshirt);
        cart.addProduct(book);

        cart.displayCartDetails();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWould you like to add another product? (yes/no)");
        String choice = scanner.nextLine();

        while (choice.equalsIgnoreCase("yes")) {
            System.out.println("Enter product type (electronics/clothing/book):");
            String type = scanner.nextLine();
            
            System.out.println("Enter product name:");
            String name = scanner.nextLine();
            
            System.out.println("Enter product price:");
            double price = scanner.nextDouble();
            scanner.nextLine();

            Product product = null;

            if (type.equalsIgnoreCase("electronics")) {
                System.out.println("Enter brand:");
                String brand = scanner.nextLine();
                product = new ElectronicsProduct(name, price, brand);
            } else if (type.equalsIgnoreCase("clothing")) {
                System.out.println("Enter size:");
                String size = scanner.nextLine();
                product = new ClothingProduct(name, price, size);
            } else if (type.equalsIgnoreCase("book")) {
                System.out.println("Enter author:");
                String author = scanner.nextLine();
                product = new BookProduct(name, price, author);
            }

            if (product != null) {
                cart.addProduct(product);
                System.out.println("Product added to cart!");
            }

            System.out.println("Would you like to add another product? (yes/no)");
            choice = scanner.nextLine();
        }

        System.out.println("\nFinal Cart Details:");
        cart.displayCartDetails();

        scanner.close();
    }
}