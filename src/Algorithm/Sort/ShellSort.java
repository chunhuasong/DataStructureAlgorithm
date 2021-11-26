package Algorithm.Sort;
import Algorithm.*;
import org.junit.Test;

import java.util.Arrays;


public class ShellSort {
    public void swap(int[] arr,int a,int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int[] ShellSort(int[] list){

        int increment = list.length;
        int i,j;

        while (increment > 1){
            increment = increment/3 + 1;
            for(i = increment;i < list.length; i++){
                for(j = i - increment;j >= 0 ;j -= increment){
                    if(list[j] > list[j + increment]){
                        swap(list,j,j+increment);
                    }
                }
            }
        }
        return list;
    }

    @Test
    public void test(){
        int[] arr = {99, 5, 69, 33, 56, 13, 22, 55, 77, 48, 12, 88, 2,69};
        ShellSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
