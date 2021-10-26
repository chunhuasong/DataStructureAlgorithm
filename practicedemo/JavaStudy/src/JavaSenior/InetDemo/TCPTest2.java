package JavaSenior.InetDemo;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//客户端发送文件给服务端 服务端将文件保存在本地
public class TCPTest2 {

    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            socket = new Socket(localHost,9090);
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("微信图片_20211025082405.jpg"));
            int len;
            byte[] buffer = new byte[1024];
            while((len = fis.read(buffer)) != -1){
                //文件输入流读到buffer buffer写到socket的输出流
                os.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            serverSocket = new ServerSocket(9090);
            socket = serverSocket.accept();

            is = socket.getInputStream();
            fos = new FileOutputStream(new File("本地微信图片.jpg"));

            int len;
            byte[] buffer = new byte[1024];
            while((len = is.read(buffer)) != -1){
                //socket输入流数据读到buffer里 再写进文件输出流
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }






    }
}
