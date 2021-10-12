package Io;

import java.io.*;

public class fileCopy {
    public static void main(String[] args) throws IOException {

        File f = new File("a.txt");
        File copy = new File("copy.txt");

        FileInputStream fip= new FileInputStream(f);
        InputStreamReader reader = new InputStreamReader(fip,"UTF-8");//读取a中字节
        StringBuffer sb = new StringBuffer();

        FileOutputStream fop= new FileOutputStream(copy);
        OutputStreamWriter writer = new OutputStreamWriter(fop,"UTF-8");//往copy中写

        while(reader.ready())
        {
            sb.append((char)reader.read());
           // System.out.println(sb);
        }

        writer.append(sb);
        reader.close();
        fip.close();

        writer.close();
        fop.close();

    }

}
