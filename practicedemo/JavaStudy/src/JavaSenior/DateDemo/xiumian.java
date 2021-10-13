package JavaSenior.DateDemo;
import java.util.*;
public class xiumian {
    public static void main(String[] args) {
        try{
            System.out.println(new Date()+"\n");
            Thread.sleep(1000*3);//休眠3s
            System.out.println(new Date()+"\n");
        } catch (Exception e) {
            System.out.println("got an exception");
        }
    }
}
