package Algorithm.Sort;

import org.junit.Test;

import java.util.List;

public class QuickSort extends swap{
// 递归 选出中间值key 分别对list左右两个list进行快排
    public void QSort(int[] list,int low,int high){
        int key;
        if(low < high){
            key = Partition(list,low,high);
            QSort(list,low,key-1);
            QSort(list,key+1,high);
        }


    }


    public int Partition(int[] list,int low,int high){
        //把比key小的都放它左边 比key大的都放它右边
        int key = list[low];
        int tmp;
        //high的处理
        while (low < high) {
            while (low < high && list[high] >= key) {
                    high--;
                }
            //swap(list[high],list[low]);
            tmp = list[low];
            list[low] = list[high];
            list[high] = tmp;
            //low的处理
            while (low < high && list[low] <= key){
                    low++;
            }
            //swap(list[high],list[low]);
            tmp = list[low];
            list[low] = list[high];
            list[high] = tmp;
        }
        return low;
    }

    @Test
    public void test(){
        int[] list = new int[]{4,6,5,3,2,9,7,8,10,45,65,23,49};
        QSort(list,0,list.length-1);
        for(int i = 0; i < list.length ;i++) {
            System.out.println(list[i]);
        }
    }

}
