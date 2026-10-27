package lesson07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ByteStreamDemo {

    public static void demoFileByteCopy() throws IOException {
        System.out.println("--- FileInputStream + FileOutputStream 字节复制 ---");
        FileInputStream in = new FileInputStream("data/poem.txt");
        FileOutputStream out = new FileOutputStream("data/poem_byte_copy.txt");

        int b;
        int count = 0;
        while ((b = in.read()) != -1) {
            out.write(b);
            count++;
        }
        in.close();
        out.close();
        System.out.println("已复制 " + count + " 字节 -> data/poem_byte_copy.txt");
    }

    public static void demoBufferedByteCopy() throws IOException {
        System.out.println("\n--- BufferedInputStream + BufferedOutputStream 高效复制 ---");
        BufferedInputStream in = new BufferedInputStream(
            new FileInputStream("data/poem.txt")
        );
        BufferedOutputStream out = new BufferedOutputStream(
            new FileOutputStream("data/poem_buffered_copy.txt")
        );

        byte[] buffer = new byte[1024];
        int len;
        int total = 0;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
            total += len;
        }
        in.close();
        out.close();
        System.out.println("已复制 " + total + " 字节(带缓冲) -> data/poem_buffered_copy.txt");
    }

    public static void demoDataStream() throws IOException {
        System.out.println("\n--- DataOutputStream / DataInputStream 读写基本类型 ---");
        DataOutputStream out = new DataOutputStream(
            new FileOutputStream("data/data_types.bin")
        );
        out.writeInt(42);
        out.writeLong(123456789L);
        out.writeFloat(3.14f);
        out.writeDouble(2.718281828);
        out.writeBoolean(true);
        out.writeChar('Z');
        out.writeUTF("Java IO DataStream!");
        out.close();
        System.out.println("已将多种基本类型写入 data/data_types.bin");

        DataInputStream in = new DataInputStream(
            new FileInputStream("data/data_types.bin")
        );
        System.out.println("读回数据:");
        System.out.println("  int   : " + in.readInt());
        System.out.println("  long  : " + in.readLong());
        System.out.println("  float : " + in.readFloat());
        System.out.println("  double: " + in.readDouble());
        System.out.println("  bool  : " + in.readBoolean());
        System.out.println("  char  : " + in.readChar());
        System.out.println("  UTF   : " + in.readUTF());
        in.close();
    }

    public static void demoByteArrayStream() throws IOException {
        System.out.println("\n--- ByteArrayOutputStream 内存中的字节缓冲 ---");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int i = 0; i < 5; i++) {
            baos.write(i);
        }
        baos.write("hello".getBytes());
        byte[] result = baos.toByteArray();
        System.out.println("缓冲区大小: " + result.length + " 字节");
        System.out.print("内容(十进制): ");
        for (byte b : result) {
            System.out.print((b & 0xFF) + " ");
        }
        System.out.println();

        System.out.println("\n--- ByteArrayInputStream 从内存字节数组读取 ---");
        ByteArrayInputStream bais = new ByteArrayInputStream(result);
        int b;
        System.out.print("读取内容: ");
        while ((b = bais.read()) != -1) {
            System.out.print((b & 0xFF) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("===== Java字节流(InputStream/OutputStream)进阶示例 =====\n");

        try {
            demoFileByteCopy();
            demoBufferedByteCopy();
            demoDataStream();
            demoByteArrayStream();
            System.out.println("\n所有字节流操作完成！");
        } catch (IOException e) {
            System.out.println("出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
