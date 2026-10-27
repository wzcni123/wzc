package lesson09;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileClassDemo {

    public static void demoFileInfo() {
        System.out.println("--- 获取文件信息 ---");
        File f = new File("data/poem.txt");
        System.out.println("路径: " + f.getPath());
        System.out.println("绝对路径: " + f.getAbsolutePath());
        System.out.println("是否存在: " + f.exists());
        System.out.println("是否文件: " + f.isFile());
        System.out.println("是否目录: " + f.isDirectory());
        System.out.println("文件大小: " + f.length() + " 字节");
        System.out.println("文件名: " + f.getName());
        System.out.println("父目录: " + f.getParent());
        System.out.println("是否可读: " + f.canRead());
        System.out.println("是否可写: " + f.canWrite());
    }

    public static void demoCreateAndDelete() {
        System.out.println("\n--- 创建与删除目录和文件 ---");
        File dir = new File("data/subdir");
        System.out.println("创建单级目录 data/subdir: " + dir.mkdir());
        File deepDir = new File("data/subdir/a/b/c");
        System.out.println("创建多级目录 data/subdir/a/b/c: " + deepDir.mkdirs());

        File newFile = new File("data/subdir/test.txt");
        try {
            System.out.println("创建新文件 data/subdir/test.txt: " + newFile.createNewFile());
        } catch (Exception e) {
            System.out.println("创建失败: " + e.getMessage());
        }

        System.out.println("删除文件 data/subdir/test.txt: " + newFile.delete());

        File notExist = new File("data/not_exist.txt");
        System.out.println("尝试删除不存在的文件: " + notExist.delete());
    }

    public static void demoListFiles() {
        System.out.println("\n--- 列出目录下所有文件 ---");
        File dir = new File("data");
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                Arrays.sort(files, Comparator.comparing(File::getName));
                System.out.println("data/ 目录内容 (" + files.length + " 项):");
                for (File f : files) {
                    String tag = f.isDirectory() ? "[DIR ]" : "[FILE]";
                    System.out.println("  " + tag + " " + f.getName() +
                        (f.isFile() ? " (" + f.length() + " bytes)" : ""));
                }
            }
        }
    }

    public static void demoFilter() {
        System.out.println("\n--- 按后缀筛选文件 ---");
        File dir = new File("data");
        File[] txtFiles = dir.listFiles((d, name) -> name.endsWith(".txt"));
        if (txtFiles != null) {
            System.out.println("data/ 下的 .txt 文件:");
            for (File f : txtFiles) {
                System.out.println("  - " + f.getName());
            }
        }
    }

    public static long countTotalSize(File dir) {
        long total = 0;
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    total += f.length();
                } else if (f.isDirectory()) {
                    total += countTotalSize(f);
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("===== Java File类与目录管理 =====\n");
        demoFileInfo();
        demoCreateAndDelete();
        demoListFiles();
        demoFilter();

        System.out.println("\n--- 递归统计目录总大小 ---");
        File dataDir = new File("data");
        long total = countTotalSize(dataDir);
        System.out.println("data/ 目录总大小: " + total + " 字节");

        System.out.println("\n清理子目录...");
        File deepDir = new File("data/subdir");
        if (deepDir.exists()) {
            deleteRecursively(deepDir);
            System.out.println("已删除 data/subdir 及其所有内容");
        }

        System.out.println("\nFile类操作完成！");
    }

    public static void deleteRecursively(File f) {
        if (f.isDirectory()) {
            File[] children = f.listFiles();
            if (children != null) {
                for (File child : children) {
                    deleteRecursively(child);
                }
            }
        }
        f.delete();
    }
}
