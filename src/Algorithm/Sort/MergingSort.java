package Algorithm.Sort;

import org.junit.Test;

/**
 * @author songhuan
 * @date 2021/11/12 10:16
 */
public class MergingSort {

    @Test
    public void test(){
        int[] list = new int[]{4,6,5,3,2,9,7,8,10,45,65,23};

        MergeSort(list);
        for(int i = 0; i < list.length ;i++) {
            System.out.println(list[i]);
        }
    }

    void MergeSort(int[] list){
        //int[] sortlist = list;
        MSort(list,list,0,list.length-1);
        //return sortlist;
    }

    //SR归并排序成TR1
     void MSort(int[] SR,int[] TR1,int s,int t) {
        int m;
        int[] TR2 = new int[SR.length];
        if(s == t){//头和尾相等了 不用排
            TR1[s] = SR[s];
        }
        else{
            m = (s+t)/2;
            MSort(SR,TR2,s,m);
            MSort(SR,TR2,m+1,t);
            Merge(TR2,TR1,s,m,t);
        }
    }

    //将有序的SR[i...m]和SR[m+1...n]归并为有序的TR[i...n]
     void Merge(int[] SR, int[] TR, int i, int m, int n) {
        int j,k,l;
        for(j = m+1,k = i;i <= m && j <= n;k++){
            //依次比较SR前半和后半的值
            if(SR[i] < SR[j]){
                TR[k] = SR[i++];//把小的放进TR
            }
            else
            {
                TR[k] = SR[j++];
            }
        }
        //将剩余的SR[i...m]复制到TR
        if(i <= m){
            for(l = 0;l <= m-i;l++){
                TR[k+l] = SR[i+l];
            }
        }
         //将剩余的SR[j...n]复制到TR
        if(j <= n){
            for(l = 0;l <= n-j;l++){
                TR[k+l] = SR[j+l];
            }
        }

    }
}
