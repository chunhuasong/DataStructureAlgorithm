package Algorithm.ComplexityOfAlgorithm;

import org.junit.Test;


//T(n) = T(n - 1) + T(n - 2) 是一个斐波那契数列
public class Fibonacci {
    long aFunc(int n){
        if(n <= 1){
            return 1;
        }
        else {
            return aFunc(n-1) +aFunc(n-2);
        }
    }

    @Test
    public void test1(){
        System.out.println(aFunc(10));
        //aFunc(100)
    }

}
