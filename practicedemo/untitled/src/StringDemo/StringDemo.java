package StringDemo;

public class StringDemo {


    public static void main(String[] args) {
//        //截取字符串
//        String str=new String("suju kada");
//        String substr=str.substring(2,6);
//        System.out.println(substr);
         //字符串转为整形
//          String str="1000";
//          String st="20";
//          int i_str1=Integer.parseInt(str);//字符串转为整型
//          int i_str2=Integer.valueOf(str);//返回保存指定的 String 的值的 Integer 对象。
//          System.out.println(i_str1);
//          System.out.println(i_str2);

        //    如何将整型 int 转换成字符串 String。 三种方式：
        //   Double, Float, Long 转成字串的方法大同小异. 除了Integer.toString(xxx)
        int i = 1000;
        String s1 = String.valueOf(i);
        String s2 = Integer.toString(i);
        String s = "" + i;

        float f = 1000.0001F;
        String s_f1 = String.valueOf(f);
        String s_f2 = Float.toString(f);
        String s_f3 = "" + f;

        // 如何将字串 String 转换成整型 int?
        String str = "10000";
        int i_str1 = Integer.parseInt(str);
        int i_str2 = Integer.valueOf(str).intValue();
        System.out.println("i_str1:" + i_str1);
        System.out.println("i_str2:" + i_str2);


    }



}
