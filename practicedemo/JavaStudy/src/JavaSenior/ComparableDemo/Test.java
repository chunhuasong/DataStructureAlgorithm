package JavaSenior.ComparableDemo;

import java.util.Arrays;

public class Test {

    @org.junit.Test
    public void test1(){
        String[] arr = new String[]{"AA","HH","CC"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
