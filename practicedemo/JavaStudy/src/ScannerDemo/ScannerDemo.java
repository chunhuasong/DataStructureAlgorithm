package ScannerDemo;
import java.util.*;
//键盘输入
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i=0;
        float f = 0.0f;
        System.out.print("输入整数：" );
        if(scan.hasNextInt()){
            i = scan.nextInt();
            System.out.println("整数数据：" + i);

        }
        else
        {
            System.out.println("输入的不是整数！");
        }
        scan.close();
    }
}
