package easy;

import java.util.*;
public class twosum {


        public static void main(String[] args){
            int[] nums= {3,2,1};

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

}
