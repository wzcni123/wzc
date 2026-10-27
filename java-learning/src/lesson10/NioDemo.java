package lesson10;

import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class NioDemo {

    public static void demoPath() {
        System.out.println("--- Path 对象基础 ---");
        Path p = Paths.get("data/poem.txt");
        System.out.println("路径: " + p);
        System.out.println("文件名: " + p.getFileName());
        System.out.println("父路径: " + p.getParent());
        System.out.println("根路径: " + p.getRoot());
        System.out.println("元素数量: " + p.getNameCount());
        for (int i = 0; i < p.getNameCount(); i++) {
            System.out.println("  元素[" + i + "]: " + p.getName(i));
        }
        System.out.println("绝对路径: " + p.toAbsolutePath());
    }

    public static void demoFilesInfo() throws IOException {
        System.out.println("\n--- Files 获取文件属性 ---");
        Path p = Paths.get("data/poem.txt");
        System.out.println("exists: " + Files.exists(p));
        System.out.println("isRegularFile: " + Files.isRegularFile(p));
        System.out.println("isDirectory: " + Files.isDirectory(p));
        System.out.println("size: " + Files.size(p) + " 字节");
        System.out.println("isHidden: " + Files.isHidden(p));
        System.out.println("lastModified: " + Files.getLastModifiedTime(p));
    }

    public static void demoFilesRead() throws IOException {
        System.out.println("\n--- Files.readAllLines 一次性读全部行 ---");
        List<String> lines = Files.readAllLines(
            Paths.get("data/poem.txt"), StandardCharsets.UTF_8
        );
        for (int i = 0; i < lines.size(); i++) {
            System.out.println("  [" + i + "] " + lines.get(i));
        }

        System.out.println("\n--- Files.readString(Java 11+) 一次读全文 ---");
        String content = Files.readString(Paths.get("data/note.txt"), StandardCharsets.UTF_8);
        System.out.println(content);
    }

    public static void demoFilesWrite() throws IOException {
        System.out.println("\n--- Files.write 写入文件 ---");
        String[] text = {
            "这是用 NIO Files.write 写入的文件。",
            "比传统 FileWriter 更简洁方便。",
            "Java 7+ 推荐使用！"
        };
        Path target = Paths.get("data/nio_output.txt");
        Files.write(target, List.of(text), StandardCharsets.UTF_8);
        System.out.println("已写入 data/nio_output.txt");

        System.out.println("\n--- 追加写入 ---");
        Files.write(target,
            List.of("这是追加的一行。"),
            StandardCharsets.UTF_8,
            StandardOpenOption.APPEND
        );
        System.out.println("已追加内容");
    }

    public static void demoFilesCopy() throws IOException {
        System.out.println("\n--- Files.copy 复制文件 ---");
        Path src = Paths.get("data/poem.txt");
        Path dst = Paths.get("data/poem_nio_copy.txt");
        Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("已复制 " + src + " -> " + dst);
        System.out.println("目标文件大小: " + Files.size(dst) + " 字节");
    }

    public static void demoFilesCreateAndDelete() throws IOException {
        System.out.println("\n--- 创建与删除 ---");
        Path dir = Paths.get("data/nio_sub");
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
            System.out.println("已创建目录 data/nio_sub");
        }
        Path file = Paths.get("data/nio_sub/hello.txt");
        Files.write(file, List.of("Hello from NIO!"), StandardCharsets.UTF_8);
        System.out.println("已创建文件 data/nio_sub/hello.txt");

        Files.deleteIfExists(file);
        Files.deleteIfExists(dir);
        System.out.println("已清理临时文件和目录");
    }

    public static void demoWalk() throws IOException {
        System.out.println("\n--- Files.walk 递归遍历目录 ---");
        try (Stream<Path> stream = Files.walk(Paths.get("data"))) {
            stream.forEach(p -> System.out.println("  " + p));
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Java NIO 新IO (java.nio.file) =====\n");

        try {
            demoPath();
            demoFilesInfo();
            demoFilesRead();
            demoFilesWrite();
            demoFilesCopy();
            demoFilesCreateAndDelete();
            demoWalk();
            System.out.println("\nNIO 所有操作完成！");
        } catch (IOException e) {
            System.out.println("出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
