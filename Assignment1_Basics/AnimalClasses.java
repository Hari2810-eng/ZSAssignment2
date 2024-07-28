/*3.Create multiple classes in single file and compile and explore how many .class files are generated.*/

public class AnimalClasses {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.sound();
        cat.sound();
    }
}

class Animal{
    void sound() {
        System.out.println("Animal Sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Meow");
    }
}

/*
Output:
After compiling, result of dir:
11-07-2024  18:06               348 Animal.class
11-07-2024  18:06               351 Animal.java
11-07-2024  18:06               389 Cat.class
11-07-2024  18:06               389 Dog.class

 The Java compiler has generated  separate .class file for each class even though they are in the same java source file.
*/