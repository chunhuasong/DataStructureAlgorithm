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

        //三数取中 优化
        int tmp;
        int m = low + (high - low);
        //左端与右端交换
        if (list[low] > list[high]) {
            tmp = list[high];
            list[high] = list[low];
            list[low] = tmp;
        }
        //中间与右端交换 保证中间小
        if (list[m] > list[high]) {
            tmp = list[high];
            list[high] = list[m];
            list[m] = tmp;
        }
        //左与中间交换 保证左边小
        if (list[low] > list[m]) {
            tmp = list[m];
            list[m] = list[low];
            list[low] = tmp;
        }

        int key = list[low];

        //优化不必要的交换 把swap改成替换
        list[0] = key;//key备份到数组第一个位置


        //high的处理
        while (low < high) {
            while (low < high && list[high] >= key) {
                    high--;
                }
            //swap(list,high,low);
//            tmp = list[low];
//            list[low] = list[high];
//            list[high] = tmp;
            list[low] = list[high];
            //low的处理
            while (low < high && list[low] <= key){
                    low++;
            }
            //swap(list,high,low);
//            tmp = list[low];
//            list[low] = list[high];
//            list[high] = tmp;
            list[high] = list[low];
        }
        list[low] = list[0];//最后再把key换回low的位置
        return low;
    }

    @Test
    public void test(){
        int[] list = new int[]{4,6,5,3,2,9,7,8,10,45,65,23,49};
        QSort(list,0,list.length-1);
        for(int i = 0; i < list.length ;i++) {
//            System.out.println(list[i]);
        }
    }

}
