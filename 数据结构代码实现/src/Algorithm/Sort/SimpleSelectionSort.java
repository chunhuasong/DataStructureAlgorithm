package Algorithm.Sort;

import org.junit.Test;

public class SimpleSelectionSort {
    public void SelectSort(int[] list){
        int min;
        int tmp;
        for(int i = 0;i < list.length-1; i++){
            min = i;
            for(int j = i+1; j < list.length;j++){
                if (list[j] < list[min]) {
                    min = j;
                }
            }
            tmp = list[min];
            list[min] = list[i];
            list[i] = tmp;
        }

        for(int i = 0; i < list.length ;i++) {
            System.out.println(list[i]);
        }
    }

    @Test
    public void test(){
        SelectSort(new int[]{4,6,5,3,2,5,9,8,65,87,12});
    }
}
