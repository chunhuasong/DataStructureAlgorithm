package Algorithm.ComplexityOfAlgorithm;

import org.junit.Test;


//T(n) = T(n - 1) + T(n - 2) 是一个斐波那契数列
//栈的应用 递归
public class Fibonacci {
    public int aFunc(int n){
        if(n <= 1){
            return 1;
        }
        else {
            return aFunc(n-1) +aFunc(n-2);
        }
    }

    @Test
    public void test1(){
        int n = 10;
        int[] F = new int[n];

        for(int i = 0; i < n;i++) {
            System.out.println(aFunc(i));
            F[i]=aFunc(i);
        }
        //aFunc(100)
    }

}
