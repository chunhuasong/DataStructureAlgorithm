package Algorithm.Searching;

import org.junit.Test;

/**
 * @author songhuan
 * @date 2021/11/12 14:24
 */
public class BinarySearch {

    int Binary_Search(int[] list,int n,int key){
        int low,high,mid;
        low = 0;
        high = n;
        while (low<=high){
            mid = (low+high)/2;
            //插值 key不能比最大值大 比最小值小
            mid = low + (high - low)*(key-list[low])/(list[high] - list[low]);

            if(key < list[mid]){
                high = mid-1;//说明要找的在mid左侧
            }
            else if(key > list[mid]){
                low = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int[] list = new int[]{1,2,3,4,5,6,7,8};

        int pos = Binary_Search(list,list.length-1,3);

        System.out.println(pos);
    }

}
