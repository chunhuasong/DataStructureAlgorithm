package JavaBasic.Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTestDemo {

    public static void main(String[] args) throws IOException,FileNotFoundException {


        //******************以下是编译时异常**********
        File file =new File("h.txt");
        //FileNotFoundException
        FileInputStream fis = new FileInputStream(file);
        int data = fis.read();//IOException
        while(data != -1){
            System.out.println((char)data);
            data = fis.read();

        }
        fis.close();


    // **********以下是运行时异常***********
//        //NullPointerException
//        int[] arr1 = null;
//        System.out.println(arr1[3]);
//
//       //IndexOutOfBoundsException
//        String str = "abc";
//        System.out.println(str.charAt(3));
//
//        int[] arr2 = new int[3];
//        System.out.println(arr2[3]);

//        // ClassCastException
//
//        Object obj = new Date();
//        String str1 = (String)obj;

//        //NumberFormatException
////        String str2 = "abc";
////        int num = Integer.parseInt(str2);

//        //InputMismatchException
//        Scanner scanner = new Scanner(System.in);
//        int score = scanner.nextInt();
//        System.out.println(score);

////ArithmeticException: / by zero
//        int y;
//        int c = 0;
//        // System.out.println(c);
//        y=3/c;
//        System.out.println("program ends ok!");
    }


}
