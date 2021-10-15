package JavaSenior.StringDemo;

import org.junit.Test;
//String的使用
public class StringTest {

    @Test
    public void test1(){
        String s1 = "abc";//字面量的定义方式
        String s2 = "abc";
        System.out.println(s1 == s2);//比较地址值
        s1 = "hello";



        System.out.println(s1);//hello
        System.out.println(s2);//abc
        System.out.println("**********************");

        String s3 = "abc";
        s3 += "def";

        System.out.println("*****************");

        String s4 = "abc";
        String s5 = s4.replace('a','m');
        System.out.println(s4);
        System.out.println(s5);//也重造了一个新内存



    }

    @Test
    public void test2(){
        String s1 = "javaEE";
        String s2 = "javaEE";
        //new+构造器 s3,s4在堆中
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");
        System.out.println(s3 == s2);//地址不同
        System.out.println(s3 == s4);//不同对象不同地址
    }

    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        String s8 = s6.intern();//返回值得到的s8使用的常量值中已经存在的“javaEEhadoop”
        System.out.println(s3 == s8);//true
    }
}
