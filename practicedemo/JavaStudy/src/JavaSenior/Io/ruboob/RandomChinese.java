package JavaSenior.Io.ruboob;

import java.io.*;
public class RandomChinese {
    public static void main(String[] args) throws IOException {
        RandomAccessFile ra = new RandomAccessFile("test.txt", "rw");
        ra.seek(0);
        ra.write("a bcd你好啊的撒法".getBytes());
        ra.seek(2);
        System.out.println("当前指针的位置："+ ra.getFilePointer());
        System.out.println(new String(ra.readLine().getBytes("ISO-8859-1"),"utf-8"));//需要重新转码才能正常显示

        ra.close();
    }
}
