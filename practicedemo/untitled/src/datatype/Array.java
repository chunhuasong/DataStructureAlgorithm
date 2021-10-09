package datatype;

import java.util.*;

public class Array {
    public static void main(String args[]) {
        int[] s;

        //int s[];
        s = new int[10];
        for (int i = 0; i < 10; i++) {
            s[i] = 2 * i + 1;
            System.out.println(s[i]);
        }

        // TODO Auto-generated method stub
        int[] number = {5, 900, 1, 5, 77, 30, 64, 700};
        Arrays.sort(number);
        for(
                int i = 0;
                i<number.length;i++)
            System.out.println(number[i]);
    }



}
