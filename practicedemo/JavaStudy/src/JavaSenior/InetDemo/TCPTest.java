package JavaSenior.InetDemo;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTest {
    //客户端发送内容给服务端，服务端将内容打印到控制台上
    @Test
    //客户端
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();//写对方的ip
            socket = new Socket(inetAddress,8899);

            os = socket.getOutputStream();
            os.write("你好我是客户端mm".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
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
        }




    }
    @Test
    //服务端
    public void server(){

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            serverSocket = new ServerSocket(8899);
            socket = serverSocket.accept();


            is = socket.getInputStream();
            //可能因为几个几个字节读 没分好 有乱码
//        byte[] buffer = new byte[5];
//        int len;
//        while((len = is.read(buffer)) != -1){
//            String str = new String(buffer,0,len);
//            System.out.print(str);

            //5个5个拼好整体读入
            baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[5];
            int len;
            while((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());
            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress()+"的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(baos != null){
                try {
                    baos.close();
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
