package Algorithm.Match;

import java.util.Arrays;

class Kmp {
//https://zhuanlan.zhihu.com/p/155942820
    public static void main(String[] args){
        String a = "abcab";
        String b = "abcaebcabcab";
        int result = kmp(b, a);

        //打印结果：和字符串获得匹配的位置
        System.out.println("resultPosion:"+result);
    }

    /**
     * KMP 匹配
     */
    public static int kmp(String str, String dest){
        //1.首先计算出 部分匹配表
        int[] next = kmpnext(dest);

        System.out.println("next ="+ Arrays.toString(next));
        //2.查找匹配位置
        for(int i = 0, j = 0; i < str.length(); i++){
            while(j > 0 && str.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }
            if(str.charAt(i) == dest.charAt(j)){
                j++;
            }
            if(j == dest.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    /**
     * 计算部分匹配表
     * 部分匹配值，其实就是计算出下标在0~i的子字符串中(i<=a.length)，前缀与后缀最长相同子串的长度。
     */
    public static int[] kmpnext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;

        for(int i = 1,j = 0; i < dest.length(); i++){
            while(j > 0 && dest.charAt(j) != dest.charAt(i)){
                j = next[j - 1];
            }
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
