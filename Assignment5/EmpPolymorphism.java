class Employee{
    String name;
    int id;
    static int idCounter = 1;
    Employee(String name){
        this.name = name;
        this.id = idCounter++;
    }
    void setName(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
    String getEmpDetails(){
        return "Employee Name : "+name+", ID :"+id;
    }
}
class HourlyEmployee extends Employee{
    int hourWorked;
    int salary;
    HourlyEmployee(String name, int hourWorked){
        super(name);
        this.hourWorked = hourWorked;
        this.salary = hourWorked * 70;
    }
    void setHoursWorked(int hours){
        this.hourWorked = hours;
        
    }
    int getHoursWorked(){
        return hourWorked;
    }
    int getSalary(){
        return salary;
    }
    @Override
    String getEmpDetails(){
        return super.getEmpDetails() + ":, Hours Worked: " + hourWorked + ", Salary: " + salary;
    }
    
}
class SalariedEmployee extends Employee{
    int annualSalary;
    
    SalariedEmployee(String name, int annualSalary){
        super(name);
        this.annualSalary = annualSalary;
    }
    int getSalary(){
        return annualSalary;
    }
    @Override
    public String getEmpDetails(){
        return super.getEmpDetails() +", Salary: "+annualSalary;
    }
}
public class EmpPolymorphism{
    public static void main(String[] args){
        Employee hourlyEmp = new HourlyEmployee("Arun", 4);
        Employee salaryEmp = new SalariedEmployee("Arun", 200000);
        
        System.out.println(hourlyEmp.getEmpDetails());
        System.out.println(salaryEmp.getEmpDetails());
    }
}
