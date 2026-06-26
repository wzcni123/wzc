package lesson05;

public class Methods {

    public static void sayHello() {
        System.out.println("你好，这是一个无参数无返回值的方法！");
    }

    public static void greet(String name) {
        System.out.println("你好，" + name + "！欢迎学习Java！");
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int max(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void printStars(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Java方法示例 =====\n");

        System.out.println("--- 1. 无参数无返回值的方法 ---");
        sayHello();

        System.out.println("\n--- 2. 带参数的方法 ---");
        greet("张三");
        greet("李四");

        System.out.println("\n--- 3. 带返回值的方法 ---");
        int sum = add(5, 3);
        System.out.println("5 + 3 = " + sum);
        System.out.println("10 + 20 = " + add(10, 20));

        int product = multiply(4, 6);
        System.out.println("4 * 6 = " + product);

        System.out.println("\n--- 4. 返回布尔值的方法 ---");
        System.out.println("4是偶数吗? " + isEven(4));
        System.out.println("7是偶数吗? " + isEven(7));

        System.out.println("\n--- 5. 多参数的方法 ---");
        int maximum = max(10, 25, 18);
        System.out.println("10、25、18中最大的数是: " + maximum);

        System.out.println("\n--- 6. 递归方法 - 阶乘 ---");
        System.out.println("5的阶乘是: " + factorial(5));
        System.out.println("10的阶乘是: " + factorial(10));

        System.out.println("\n--- 7. 打印图形的方法 ---");
        System.out.println("打印5行星号:");
        printStars(5);
    }
}
