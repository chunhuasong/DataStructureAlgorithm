package Algorithm.Sort;

import org.junit.Test;

/**
 * @author 不知道是哪位大佬写的 写得真nb!
 * @date 2021/11/12 13:00
 */
public class MergingSort2 {
    //对顺序表实现非递归归并排序
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];//保存每一轮的归并结果（步长为1,2,4……的比较结果）
        int block, start;

        // block为间隔
        for(block = 1; block < len*2; block *= 2) {
            for(start = 0; start <len; start += 2 * block) {
                // 控制间隔
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                // 两段的首尾
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                // 开始对两个block进行归并排序
                // 优美啊
                while (start1 < end1 && start2 < end2) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while(start1 < end1) {
                    result[low++] = arr[start1++];
                }
                while(start2 < end2) {
                    result[low++] = arr[start2++];
                }
            }
            // 互换
            int[] temp = arr;
            arr = result;
            result = temp;
        }
        //result = arr;
    }



    @Test
    public void test(){
        int[] list = new int[]{4,6,5,3,2,9,7,8,10,45,65,23};

        merge_sort(list);
        for(int i = 0; i < list.length ;i++) {
            System.out.println(list[i]);
        }
    }
}

