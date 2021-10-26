package JavaSenior.InetDemo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLOutput;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("192.168.10.14");
        System.out.println(inetAddress);

        InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
        //域名
        System.out.println(inetAddress1);
        System.out.println(inetAddress1.getHostName());
        System.out.println(inetAddress1.getHostAddress());

        //本地回路地址
        InetAddress inetAddress2 = InetAddress.getByName("127.0.0.1");
        System.out.println(inetAddress2);

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);


    }
}
