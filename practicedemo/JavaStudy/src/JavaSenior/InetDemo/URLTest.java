package JavaSenior.InetDemo;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    @Test
    public void Test1() throws MalformedURLException {
        URL url = new URL("http://localhost:8080/faw_war/deviceStatus/index.html");
        System.out.println("getProtocol() :"+url.getProtocol());
        System.out.println("getHost() :"+url.getHost());
        System.out.println("getPort() :"+url.getPort());
        System.out.println("getPath() :"+url.getPath());
        System.out.println("getFile() :"+url.getFile());
        System.out.println("getQuery() :"+url.getQuery());
    }

    @Test
    public void Test2()  {
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://localhost:8080/faw_war/deviceStatus/index.html");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("index.html");

            int len;
            byte[] buffer = new byte[1024];
            while((len = is.read(buffer)) != -1){
                //文件输入流读到buffer buffer写到socket的输出流
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
            if(urlConnection != null){
                urlConnection.disconnect();
            }
        }




    }
}
