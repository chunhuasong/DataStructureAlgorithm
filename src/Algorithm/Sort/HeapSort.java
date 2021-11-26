package Algorithm.Sort;

import org.junit.Test;
import sun.net.www.protocol.http.HttpURLConnection;

import java.util.List;

/**
 * @author songhuan
 * @date 2021/11/12 8:38
 */
public class HeapSort {
    public void swap(int[] arr,int a,int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    void HeapSort(int[] list){
        int i;
        //将每个非终端节点当做根节点，将其和其子树调整为大顶堆
        for(i = list.length/2 - 1;i >= 0;i--){
            //0-length/2 是非叶子节点
            HeadAdjust(list,i,list.length-1);
        }
        //这里已经实现了一个大顶堆 是把数组从大到小排了个堆
        for(i = list.length-1;i >= 1;i--){
            //堆顶元素和当前未经排序子序列的最后一个元素交换
            swap(list,0,i);
            //再次调整去除最大值的这个堆
            HeadAdjust(list,0,i-1);
        }
    }


    void HeadAdjust(int[]list,int s,int m){
        int temp,j;
        temp = list[s];
        for(j=2*s + 1;j<=m;j = 2*j +1){
            if (j < m && list[j] < list[j+1]) {
                    ++j; //j记录关键字较大的节点
            }
            if(temp >= list[j]){
                break;
                //如果子树根节点大 就不用换
            }
            list[s] = list[j];
            s = j;
        }
        list[s] = temp;
    }

    @Test
    public void test(){
        int[] list = new int[]{4,6,5,3,2,9,7,8,10,45,65,23};
        HeapSort(list);
        for(int i = 0; i < list.length ;i++) {
            System.out.println(list[i]);
        }
    }
}
