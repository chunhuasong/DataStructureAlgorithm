package JavaSenior.StringDemo;

import org.junit.Test;

import java.util.Arrays;

//String转换为基本数据类型、包装类

public class StringChange {

    @Test
    public void test2(){
//String 转 char[]
        String str1 = "abc123";

        char[] charArray = str1.toCharArray();

        for(int i = 0;i < charArray.length;i++){
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);

    }



    @Test
    public void test3(){
        String str1 = "abc123";
        byte[] bytes = str1.getBytes();
        System.out.println(Arrays.toString(bytes));
    }
}
