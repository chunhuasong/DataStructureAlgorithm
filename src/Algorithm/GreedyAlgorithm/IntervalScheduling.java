package Algorithm.GreedyAlgorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author songhuan
 * @date 2021/11/24 14:50
 * 区间调度问题
 */
public class IntervalScheduling {

    //算出这些区间中最多有几个互不相交的区间。

    int intervalSchedule(int[][] intvs){
        //区间按end升序排序
        if(intvs.length == 0){
            return 0;
        }
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] intv1, int[] intv2) {
                if(intv1[1] - intv2[1] > 0){
                    return 1;
                }
                if(intv1[1] - intv2[1] > 0){
                    return -1;
                }
                return 0;
            }
        });
        //不相交区间个数最少是1：代表和排序的第一个区间没有不相交的 所以初始化为1
        int count = 1;
        //排序后第一个区间的end 记录下来
        int x_end = intvs[0][1];
        //遍历区间组的行
        for(int[] intv : intvs){
            int start = intv[0];
            //某个区间的头 >= x_end 说明它们不相交
            if(start >= x_end){
                count++;
                //把这个区间的尾部 赋值个x_end
                x_end = intv[1];
            }
        }
        return count;
    }


    @Test
    public void test(){
        int[][] intvs = {{1,3}, {2,4}, {3,6},{9,13}};
        System.out.println(intervalSchedule(intvs));
    }

}
