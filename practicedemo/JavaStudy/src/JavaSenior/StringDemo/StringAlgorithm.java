package JavaSenior.StringDemo;

import org.junit.Test;

import java.util.Arrays;

public class StringAlgorithm {


    @Test
    public void reverse() {
        //abcdefg--->abfedcg
        String str = "abcdefg";

        char[] arr = str.toCharArray();

        int startIndex = 2;
        int endIndex = arr.length - 2;

        for (; endIndex > startIndex; endIndex--, startIndex++) {
            char temp;
            temp = arr[endIndex];
            arr[endIndex] = arr[startIndex];
            arr[startIndex] = temp;
        }
        System.out.println(arr);
    }

    @Test
    public void trim() {

        String ori = "  fjju   rr  t";
        char[] arr = ori.toCharArray();
        int start = 0, end = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                start = i;
                break;
            }
        }

        for (int j = arr.length - 1; j < 0; j--) {
            if (arr[j] != ' ') {
                end = j;
                break;
            }
        }
        String changed = ori.substring(start, end+1);
        System.out.println(changed);
        System.out.println(changed.length());

    }

    @Test
    public void occurCount(){
        //获取一个字符串在另一个字符串中出现的次数。
        //比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
        String str = "abkkcadkabkebfkabkskab";
        String substr = "ab";
        int offset = substr.length();
        int index = 0;
        int count = 0;
        while(index != -1 & index < str.length()-1) {
            count++;
            index = str.indexOf(substr, index + offset);
        }
        System.out.println(count);


    }

    @Test
    public void charSort(){
        //5.对字符串中字符进行自然顺序排序。
        //提示：
        //1）字符串变成字符数组。
        //2）对数组排序，选择，冒泡，Arrays.sort();
        //3）将排序后的数组变成字符串。

        String str = "avnjdkshgu";
        char[] arr = str.toCharArray();
        //Arrays.sort(arr);
        //冒泡法排序
        char tmp;
        for(int i = 0;i < arr.length ; i++){
            for(int j = 0; j < arr.length-i-1 ;j++) {
                if (arr[j] > arr[j+1]) {
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }

        }
        System.out.println(arr);
    }


    public String getMaxMatchSubstr(String str1,String str2){
        //获取两个字符串中最大相同子串。比如：
        //str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
        //提示：将短的那个串进行长度依次递减的子串与较长的串比较。
        //子串依次后移，匹配


        String maxStr = (str1.length() >= str2.length())?str1:str2;
        String minStr = (str1.length() < str2.length())?str1:str2;

        int length = minStr.length();
        for(int i = 0;i < length;i++){
            for(int x = 0, y = length - i;y <= length;x++,y++){

                String subStr = minStr.substring(x,y);
                        if(maxStr.contains(subStr)){
                            return subStr;
                        }
            }
        }

        return null;
    }

     @Test
    public void testMaxSubStr(){
         String str1 = "abcwerthelloyuiodef";
         String str2 = "cvhellobnm";
         String maxSub = getMaxMatchSubstr(str1,str2);
         System.out.println(maxSub);

     }

    // 如果存在多个长度相同的最大相同子串
    // 此时先返回String[]，后面可以用集合中的ArrayList替换，较方便
    public String[] getMaxSameString1(String str1, String str2) {
        if (str1 != null && str2 != null) {
            StringBuffer sBuffer = new StringBuffer();
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;

            int len = minString.length();
            for (int i = 0; i < len; i++) {
                for (int x = 0, y = len - i; y <= len; x++, y++) {
                    String subString = minString.substring(x, y);
                    if (maxString.contains(subString)) {
                        sBuffer.append(subString + ",");
                    }
                }
                  //System.out.println(sBuffer);
                if (sBuffer.length() != 0) {
                    break;
                }
            }
            String[] split = sBuffer.toString().replaceAll(",$", "").split("\\,");

            return split;
        }

        return null;
    }

    @Test
    public void testGetMaxSameString(){
        String str1 = "abcwerthello1yuiodefabcdef";
        String str2 = "cvhello1bnmabcdef";
        String[] maxSameStrings = getMaxSameString1(str1, str2);
        System.out.println(Arrays.toString(maxSameStrings));

    }
    }



