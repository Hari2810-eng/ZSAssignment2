import java.util.Scanner;

abstract class Employee{
    protected String name;
    protected int id;

    Employee(String name, int id){
        this.name = name;
        this.id = id;
    }
   
    String getEmpDetails(){
        return "Employee Name : "+name+", ID :"+id;
    }

    abstract double calculatePay();
}
class HourlyEmployee extends Employee{
    private int hourWorked;
    private double hourlyRate;
    HourlyEmployee(String name, int id, int hourWorked, double hourlyRate){
        super(name, id);
        this.hourWorked = hourWorked;
        this.hourlyRate = hourlyRate;
    }
    public double calculatePay(){
        return hourWorked * hourlyRate;
    }
    
}
class SalariedEmployee extends Employee{
    double annualSalary;
    
    SalariedEmployee(String name, int id, double annualSalary){
        super(name, id);
        this.annualSalary = annualSalary;
    }
    
    @Override
    public double calculatePay(){
        return annualSalary/2;
    }
}
public class EmpAbstract{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter 1 for Hourly Employee, 2 for Salaried Employee:");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        
        Employee employee = null;

        if (choice == 1) {
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            System.out.println("Enter ID:");
            int id = scanner.nextInt();
            System.out.println("Enter hourly rate:");
            double hourlyRate = scanner.nextDouble();
            System.out.println("Enter hours worked:");
            int hoursWorked = scanner.nextInt();
            
            employee = new HourlyEmployee(name, id, hoursWorked, hourlyRate);
        } else if (choice == 2) {
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            System.out.println("Enter ID:");
            int id = scanner.nextInt();
            System.out.println("Enter annual salary:");
            double annualSalary = scanner.nextDouble();
            
            employee = new SalariedEmployee(name, id, annualSalary);
        }

        if (employee != null) {
            System.out.println(employee.getEmpDetails());
            System.out.println("Calculated Pay: " + employee.calculatePay());
        } else {
            System.out.println("Invalid choice!");
        }
        scanner.close();
    }
}
