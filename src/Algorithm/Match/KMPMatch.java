package Algorithm.Match;

import org.junit.Test;

public class KMPMatch {

    @Test
    public void test(){

        String a = "ABACABAD";
        String c = "B";
        String b = "BBC ABACABACABAD ABCDABDE";
        int result =Index_KMP(b,c);
        System.out.println("resultPosion:"+result);

    }

    public int Index_KMP(String S, String T){
        //返回子串T在主串S中的位置。若不存在，返回-1
        int[] next = KMPnext(T);
        int i = 0;
        int j = 0;

        while (i < S.length() & j <T.length()){
            if(j == 0 | S.charAt(i) == T.charAt(j)) {
                //增加一个判断条件 j==0
                j++;
                i++;
            }
            else {
                j = next[j - 1];//j 不退回到0 回到合适位置
            }

        }
        if(j == T.length()){
            return i-T.length()+1;
        }
        else {
            return -1;
        }



    }

    public int[] KMPnext(String T){
       //生成子串的部分匹配表
        int[] next = new int[T.length()];
        next[0] = 0;

        for(int i = 1,j = 0; i < T.length(); i++){
            //i代表后缀 j代表前缀
            while(j > 0 && T.charAt(j) != T.charAt(i)){
                j = next[j - 1];
            }
            if(T.charAt(i) == T.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
