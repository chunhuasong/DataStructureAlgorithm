package JavaSenior.InetDemo;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//客户端发送文件给服务端 服务端将文件保存在本地，并返回“发送成功”给客户端，并关闭相应的连接。
public class TCPTest3 {

    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
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
            //read阻塞式方法 不写停就不会停
            socket.shutdownOutput();//告诉服务端 客户端不再发数据了
            //接收来自服务器端的数据，并显示到控制台上
            InputStream is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[20];
            int len1;
            while((len1 = is.read(buffer1)) != -1){
                baos.write(buffer1,0,len1);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            serverSocket = new ServerSocket(9090);
            socket = serverSocket.accept();

            is = socket.getInputStream();
            fos = new FileOutputStream(new File("本地微信图片2.jpg"));

            int len;
            byte[] buffer = new byte[1024];
            while((len = is.read(buffer)) != -1){

                //socket输入流数据读到buffer里 再写进文件输出流
                fos.write(buffer,0,len);
            }
            System.out.println("图片传输完成");
            //服务器端给予客户端反馈
            os = socket.getOutputStream();
            os.write("收到图片了".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
