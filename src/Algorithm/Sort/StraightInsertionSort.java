package Algorithm.Sort;

import org.junit.Test;

public class StraightInsertionSort {

    public void StraightInsertionSort(int[] list){
        int tmp;
        //list[0]是初始有序表

        for(int i = 1; i < list.length; i++){
            tmp = list[i];
            if (list[i] < list[i-1]) {
                int j;
                //内层是已排序的
                for(j = i - 1; j >= 0 ;j--){
                        //有序表中后移
                    if(tmp < list[j]){
                        list[j+1] = list[j];
                    }
                    else
                        break;
                }
                list[j+1] = tmp;
            }
        }
        for(int i = 0; i < list.length ;i++) {
            System.out.println(list[i]);
        }
    }

    @Test
    public void test(){
        StraightInsertionSort(new int[]{4,6,5,3,2,9,7});
    }

}
