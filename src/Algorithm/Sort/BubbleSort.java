package Algorithm.Sort;

import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements Comparable{

   //最基本的冒泡法排序
    public void BubbleSort(int[] list){
        //冒泡法排序 小的往上冒泡
        int tmp;
        for(int i = 0; i < list.length - 1;i++){
            for(int j = i+1; j < list.length;j++){
                if(list[i] > list[j]){
                    tmp = list[j];
                    list[j] = list[i];
                    list[i] = tmp;
                }
            }
        }
        for(int i = 0; i < list.length ;i++) {
            System.out.println(list[i]);
        }

    }

    // 冒泡改进1：内层循环从后往前找 相邻比较交换
    public void BubbleSort1(int[] list){
        //冒泡法排序 小的往上冒泡
        int tmp;
        for(int i = 0; i < list.length - 1;i++){
            for(int j = list.length - 1; j >= i+1;j--){
                if(list[j-1] > list[j]){

                    tmp = list[j-1];
                    list[j-1] = list[j];
                    list[j] = tmp;
                }
            }
        }
        for(int i = 0; i < list.length ;i++) {
            System.out.println(list[i]);
        }

    }

    //冒泡改进2：加入标志判断是否中途就已经有序
    public void BubbleSort2(int[] list){
        //冒泡法排序 小的往上冒泡
        int tmp;
        boolean flag = true;// flag代表一开始是无序的
        for(int i = 0; i < list.length - 1 && flag;i++){
            flag = false;//每次走一次循环看剩下的是不是有序的，如果下边没发生交换 就已经有序了
            for(int j = list.length - 1; j >= i+1;j--){
                if(list[j-1] > list[j]){

                    tmp = list[j-1];
                    list[j-1] = list[j];
                    list[j] = tmp;
                    flag = true;

                }
            }
        }
        for(int i = 0; i < list.length ;i++) {
            System.out.println(list[i]);
        }

    }

    @Test
    public  void test(){
        BubbleSort(new int[]{2,1});
        BubbleSort(new int[]{3,6,2,8,0});

        System.out.println("********************");
        BubbleSort1(new int[]{1,7,3,78,45,2,64,72});
        System.out.println("********************");
        BubbleSort2(new int[]{4,6,5,3,2,5,9,8,65,87,12});
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
