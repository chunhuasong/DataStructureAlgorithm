package Algorithm.Sort;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

//直接交换不可行
public class swap {


    public void swap(int[] arr,int a,int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    @Test
    public void test(){
        int low = 0;
        int high = 1;
        int[] arr = new int[1024];
        swap(arr,0,1);
        System.out.println("low="+ low);
        System.out.println("high="+ high);
    }

}







