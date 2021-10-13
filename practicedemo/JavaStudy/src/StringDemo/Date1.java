package StringDemo;
import  java.util.*;
import java.text.*;
public class Date1 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("date:"+date);
        String strDateFormat1="yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf1= new SimpleDateFormat(strDateFormat1);
        System.out.println("sdf1:"+ sdf1.format(date));
    }
}
