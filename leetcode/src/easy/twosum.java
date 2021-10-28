package easy;

import java.util.*;
public class twosum {


        public static void main(String[] args){
            int[] nums= {3,2};
            //int[] result = new int[2];
            int[] result = new int[]{};
            result = new int[]{1, 2};
            int target = 6;
            int one;
            int two;
            for(int i=0;i<nums.length-1;i++)
            {
                for(int j=1;j<nums.length;j++)
                {
                    one=nums[i];
                    two=nums[j];
                    if(one+two==target)
                    {
                        System.out.println("["+i+","+j+"]");

                    }
                    if(i==nums.length-2 & j==nums.length-1 & one+two != target)
                       System.out.println("无答案");
                }

            }

        }
//两层循环
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{};
        for(int i = 0;i < nums.length-1;i++){
            for(int j = i+1;j < nums.length;j++){
                if(target - nums[i] == nums[j]){

                    result = new int[]{i,j};
                    return result;
                }
            }
        }
        return result;
    }


}
