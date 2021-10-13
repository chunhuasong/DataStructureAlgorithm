package JavaSenior.StringDemo;

public class StringDemo2 {
    public static void main(String[] args) {
        // 求字符串长度
        String str = new String("abcdefg");

        int length = str.length();
        System.out.println("长度:" + length);

        // 用String类的substring方法可以提取字符串中的子串，该方法有两种常用参数:
        String substring1 = str.substring(4);
        System.out.println("第N个开始获值:" + substring1);

        String substring2 = str.substring(2, 5);
        System.out.println("第N个-M个开始获值:" + substring2);

        // 字符串比较
        String str1 = new String("abc");
        String str2 = new String("ABC");
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str2.toLowerCase()));
        System.out.println(str2.equals(str1.toUpperCase()));

        // 字符串中单个字符\字符串查找
        //用于查找当前字符串中字符或子串，返回字符或子串在当前字符串中从左边起首次出现的位置，若没有出现则返回-1。
        String str3 = "abcdefgabcabc";
        String str4 = "fg";
        String str5 = "xyz";
        char char1 = 'd';

//        System.out.println("str3.indexOf(str4) :" + str3.indexOf(str4));
//        System.out.println("str3.indexOf(str5) :" + str3.indexOf(str5));
//        System.out.println("str3.indexOf(char1) :" + str3.indexOf(char1));
//
        // 字符串中字符的替换
        System.out.println("  str3.replace(\"abc\" ,  str5):  " + str3.replace("abc", str5));

        // 去除前后空格
        String str6 = " xy  z    ";
        System.out.println(" str6.trim():" + str6.trim());
    }
}
