package lesson08;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private double salary;
    private transient String password;

    public Person() {}

    public Person(String name, int age, double salary, String password) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.password = password;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getPassword() { return password; }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age +
               ", salary=" + salary + ", password='" + password + "'}";
    }
}
