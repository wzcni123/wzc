package lesson08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class SerializationDemo {

    public static void serializeOnePerson() throws IOException {
        System.out.println("--- 序列化单个对象 ---");
        Person p = new Person("张三", 28, 15000.0, "secret123");
        System.out.println("要序列化的对象: " + p);

        ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream("data/person.ser")
        );
        oos.writeObject(p);
        oos.close();
        System.out.println("已写入 data/person.ser");
    }

    public static Person deserializeOnePerson() throws IOException, ClassNotFoundException {
        System.out.println("\n--- 反序列化单个对象 ---");
        ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream("data/person.ser")
        );
        Person p = (Person) ois.readObject();
        ois.close();
        System.out.println("读回的对象: " + p);
        if (p.getPassword() == null) {
            System.out.println("注意: password 字段为 null, 因为用了 transient 关键字被跳过");
        }
        return p;
    }

    public static void serializeList() throws IOException {
        System.out.println("\n--- 序列化对象列表 ---");
        List<Person> people = new ArrayList<>();
        people.add(new Person("张三", 25, 12000.0, "pass1"));
        people.add(new Person("李四", 30, 18000.0, "pass2"));
        people.add(new Person("王五", 22, 9000.0, "pass3"));

        ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream("data/people_list.ser")
        );
        oos.writeObject(people);
        oos.close();
        System.out.println("已写入 " + people.size() + " 个Person到 data/people_list.ser");
    }

    @SuppressWarnings("unchecked")
    public static void deserializeList() throws IOException, ClassNotFoundException {
        System.out.println("\n--- 反序列化对象列表 ---");
        ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream("data/people_list.ser")
        );
        List<Person> people = (List<Person>) ois.readObject();
        ois.close();
        for (Person p : people) {
            System.out.println("  " + p);
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Java对象序列化与反序列化 =====\n");

        try {
            serializeOnePerson();
            deserializeOnePerson();
            serializeList();
            deserializeList();
            System.out.println("\n所有序列化操作完成！");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
