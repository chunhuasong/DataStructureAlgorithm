package Algorithm.Searching;

import org.junit.Test;

/**
 * @author songhuan
 * @date 2021/11/12 15:46
 */
public class Finonacci_Search {

    @Test
    public void test(){
        int[] list = new int[]{1,2,3,4,5,6,7,8};

        int pos = Finonacci_Search(list,list.length-1,9);

        System.out.println(pos);
    }


    public int aFunc(int n){
        if(n <= 1){
            return 1;
        }
        else {
            return aFunc(n-1) +aFunc(n-2);
        }
    }



    int Finonacci_Search(int[] list,int n,int key){
        int low,high,mid,i,k;
        low = 1;
        high = n;
        k = 0;

        //构造斐波那契数列
        int[] F = new int[list.length];
        for(int j = 0; j < n;j++) {
            //System.out.println(aFunc(j));
            F[j]=aFunc(j);
        }


        while(n > F[k]-1){
            //计算n在斐波那契数列的位置
            k++;
        }
        for(i = n;i<F[k]-1;i++){
            list[i]=list[n];//现在n和F[k]-1差了一些 补齐后面的值 构造一个F[k]-1个数的数组
        }
        while(low <= high){
            mid = low+F[k-1]-1;
            if(key < list[mid]){
                high = mid - 1;
                k = k - 1;    //在左侧的F[k-1]-1个数里面找
            }
            else if(key > list[mid]){
                low = mid + 1;
                k = k - 2;//右边是F[k-2]-1个数
            }
            else{
                if(mid <= n){
                    return mid;
                }
                else{
                    return n;
                }
            }
        }
        return -1;
    }
}
