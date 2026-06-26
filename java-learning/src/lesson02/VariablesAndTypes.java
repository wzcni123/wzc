package lesson02;

public class VariablesAndTypes {
    public static void main(String[] args) {
        System.out.println("===== Java变量与数据类型示例 =====\n");

        byte age = 25;
        short year = 2026;
        int studentId = 123456;
        long worldPopulation = 8000000000L;

        System.out.println("--- 整数类型 ---");
        System.out.println("年龄(byte): " + age);
        System.out.println("年份(short): " + year);
        System.out.println("学号(int): " + studentId);
        System.out.println("世界人口(long): " + worldPopulation);

        float price = 19.99f;
        double pi = 3.14159265359;

        System.out.println("\n--- 浮点类型 ---");
        System.out.println("商品价格(float): " + price);
        System.out.println("圆周率(double): " + pi);

        char grade = 'A';
        char chineseChar = '中';

        System.out.println("\n--- 字符类型 ---");
        System.out.println("成绩等级(char): " + grade);
        System.out.println("中文字符(char): " + chineseChar);

        boolean isJavaFun = true;
        boolean isRaining = false;

        System.out.println("\n--- 布尔类型 ---");
        System.out.println("Java有趣吗?: " + isJavaFun);
        System.out.println("在下雨吗?: " + isRaining);

        String name = "张三";
        String message = "学习Java很快乐！";

        System.out.println("\n--- 字符串类型(引用类型) ---");
        System.out.println("姓名: " + name);
        System.out.println("消息: " + message);

        System.out.println("\n--- 变量的基本操作 ---");
        int x = 10;
        System.out.println("初始x = " + x);
        x = 20;
        System.out.println("修改后x = " + x);
        int y = x + 5;
        System.out.println("y = x + 5 = " + y);

        final double PI = 3.14159;
        System.out.println("\n--- 常量(final) ---");
        System.out.println("圆周率常量: " + PI);
    }
}
