package Algorithm.Match;

import org.junit.Test;

public class NormalMatch {
    int j = 0;
    int i = 0;
    int Index(String S,String T){
        while (i < S.length() & j <T.length()){
            if(S.charAt(i) == T.charAt(j)) {
                    j++;
                    i++;
            }
            else {
                i = i-j + 1;
                j = 0;
            }

        }
        if(j == T.length()){
            return i-T.length()+1;
        }
        else {
            return -1;
        }

    }

    @Test
    public void test(){

        String a = "ABACABAD";
        String b = "BBC ABACABACABAD ABCDABDE";
        int result = Index(b,a);
        System.out.println("resultPosion:"+result);

    }
}
