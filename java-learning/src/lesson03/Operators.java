package lesson03;

public class Operators {
    public static void main(String[] args) {
        System.out.println("===== Java运算符示例 =====\n");

        int a = 10;
        int b = 3;

        System.out.println("--- 算术运算符 ---");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        System.out.println("\n--- 自增自减运算符 ---");
        int c = 5;
        System.out.println("初始c = " + c);
        System.out.println("c++ = " + (c++));
        System.out.println("执行c++后c = " + c);
        System.out.println("++c = " + (++c));
        System.out.println("执行++c后c = " + c);

        System.out.println("\n--- 赋值运算符 ---");
        int d = 10;
        System.out.println("初始d = " + d);
        d += 5;
        System.out.println("d += 5 后 d = " + d);
        d -= 3;
        System.out.println("d -= 3 后 d = " + d);
        d *= 2;
        System.out.println("d *= 2 后 d = " + d);
        d /= 4;
        System.out.println("d /= 4 后 d = " + d);

        System.out.println("\n--- 比较运算符 ---");
        int x = 10;
        int y = 20;
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("x == y : " + (x == y));
        System.out.println("x != y : " + (x != y));
        System.out.println("x > y  : " + (x > y));
        System.out.println("x < y  : " + (x < y));
        System.out.println("x >= 10: " + (x >= 10));
        System.out.println("y <= 20: " + (y <= 20));

        System.out.println("\n--- 逻辑运算符 ---");
        boolean p = true;
        boolean q = false;
        System.out.println("p = " + p + ", q = " + q);
        System.out.println("p && q (与): " + (p && q));
        System.out.println("p || q (或): " + (p || q));
        System.out.println("!p (非)   : " + (!p));
        System.out.println("!q (非)   : " + (!q));

        System.out.println("\n--- 字符串连接 ---");
        String firstName = "张";
        String lastName = "三";
        String fullName = firstName + lastName;
        System.out.println("姓: " + firstName);
        System.out.println("名: " + lastName);
        System.out.println("全名: " + fullName);
        System.out.println("年龄: " + 25 + "岁");

        System.out.println("\n--- 三元运算符 ---");
        int score = 85;
        String result = (score >= 60) ? "及格" : "不及格";
        System.out.println("分数: " + score);
        System.out.println("结果: " + result);
        int max = (a > b) ? a : b;
        System.out.println("a和b中较大的数是: " + max);
    }
}
