package lesson04;

public class ControlFlow {
    public static void main(String[] args) {
        System.out.println("===== Java控制流程示例 =====\n");

        System.out.println("--- if-else条件判断 ---");
        int score = 85;
        System.out.println("考试分数: " + score);

        if (score >= 90) {
            System.out.println("等级: 优秀 (A)");
        } else if (score >= 80) {
            System.out.println("等级: 良好 (B)");
        } else if (score >= 70) {
            System.out.println("等级: 中等 (C)");
        } else if (score >= 60) {
            System.out.println("等级: 及格 (D)");
        } else {
            System.out.println("等级: 不及格 (F)");
        }

        System.out.println("\n--- switch多分支选择 ---");
        int dayOfWeek = 3;
        System.out.println("星期数字: " + dayOfWeek);
        switch (dayOfWeek) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期日");
                break;
            default:
                System.out.println("无效的日期");
        }

        System.out.println("\n--- for循环 - 打印1到10 ---");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\n--- for循环 - 计算1到100的和 ---");
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1到100的和是: " + sum);

        System.out.println("\n--- while循环 - 倒计时 ---");
        int countdown = 5;
        while (countdown > 0) {
            System.out.print(countdown + " ");
            countdown--;
        }
        System.out.println("发射！");

        System.out.println("\n--- do-while循环 - 至少执行一次 ---");
        int num = 1;
        do {
            System.out.print(num + " ");
            num++;
        } while (num <= 5);
        System.out.println();

        System.out.println("\n--- break语句 - 找到第一个大于50的数 ---");
        for (int i = 1; i <= 100; i++) {
            if (i > 50) {
                System.out.println("找到了: " + i);
                break;
            }
        }

        System.out.println("\n--- continue语句 - 打印1到10中的偶数 ---");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\n--- 嵌套循环 - 打印乘法表(5x5) ---");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "x" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}
