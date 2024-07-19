class Person {
    String name;
    int age;
    String address;
    Person(String name){
        this.name = name;
    }
    Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    Person(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }
    void printValues(){
        System.out.println("Name: " +name);
        System.out.println("Age: " + age);
        System.out.println("Address: "+address +"\n");
    }
}
public class Main{

    public static void main(String[] args) {
        Person person1 = new Person("Abi");
        System.out.println("Person1: ");
        person1.printValues();
        
        System.out.println("Person2: ");
        Person person2 = new Person("Anu", 23);
        person2.printValues();
        
        System.out.println("Person3: ");
        Person person3 = new Person("Ammu", 21, "123/9, N.G.G.O. Colony, Madurai");
        person3.printValues();
        
    }
}
