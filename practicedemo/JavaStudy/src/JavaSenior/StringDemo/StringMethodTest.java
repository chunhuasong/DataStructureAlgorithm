package JavaSenior.StringDemo;

import org.junit.Test;

public class StringMethodTest {

    @Test
    public void test1(){
        String s1 = "helloworld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        //System.out.println(s1.charAt(10));
        System.out.println(s1.isEmpty());

        //String s2 = s1.toLowerCase();
        String s2 = s1.toUpperCase();
        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "  he  llo   world    ";
        String s4 =s3.trim();//去除首尾空格
        System.out.println("------" + s3 + "--------");
        System.out.println("------" + s4 + "--------");


        String s5 = "abc";
        String s6 = new String("0");
        System.out.println(s5.compareTo(s6));//abc-abe

        String s7 = "北京尚硅谷教育";
        String s8 = s7.substring(2);
        System.out.println(s8);
        String s9 = s7.substring(2,5);
        System.out.println(s9);

        String str = "12hello34world5java7891mysql456";
//把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);

        String str2 = "12345";
//判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str2.matches("\\d+");// \\d就是数字
        System.out.println(matches);
        String tel = "0571-4534289";
//判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);

    }

}
