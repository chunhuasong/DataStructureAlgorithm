package JavaSenior.Io;

import java.io.*;

public class RandomAccessFileDemo {
    public static void main(String[] args) throws FileNotFoundException {
        try{

            //创建文件
            File file = new File("E:\\Javacode\\words.txt");
            if(file.exists()){
                file.delete();
                file.createNewFile();
            }

            //创建RandomAccessFile对象，以读写方式操作file
            RandomAccessFile raf = new RandomAccessFile(file,"rw");
            System.out.println("当前指针的位置："+ raf.getFilePointer());
            //raf.seek(0);
            //先定义写入的字符串，再进行格式转换
            String str1 = "晴天，阴天，多云，小雨，大风，中雨，小雪，雷阵雨";
            String str2 = new String(str1.getBytes("GBK"),"ISO-8859-1");
            raf.writeBytes(str2);

            //打印出当前指针的位置，然后将其移动到第 6 个字节。
            // 再定义一个长度为 2 的 byte 数组，然后开始进行内容的循环读取，将读出的内容以字符串的形式输出到控制台
            System.out.println("写完字符串指针的位置："+ raf.getFilePointer());
            //System.out.println(new String(raf.readLine().getBytes("ISO-8859-1"),"utf-8"));
            raf.seek(6);
            System.out.println("移动后指针的位置："+ raf.getFilePointer());
            System.out.println("从文件头跳过6个字节，现在文件内容如下：");
//            byte[] buffer = new byte[2];
//            int len = 0;
//            while((len = raf.read(buffer,0,2)) != -1){
//                System.out.print(new String(buffer,0,len));
//            }
            System.out.println(new String(raf.readLine().getBytes("ISO-8859-1"),"GBK"));


        } catch (Exception e) {
            System.out.println(e);
        }



    }
}
