package Algorithm.DynamicProgramming;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author songhuan
 * @date 2021/11/24 10:45
 * 有N种物品和一个容量为V的背包，每种物品都有无限件可用。
 * 第i种物品的体积size，价值是val。
 * 将哪些物品装入背包可使这些物品的体积总和不超过背包容量，且价值总和最大。
 */
public class KnapsackFull {
    int KnapsackFull(int V,int N,int[] size,int[] val){
        //状态变化：dp[i][v] 当容量w的背包只装了前i种物品时（可重复使用） 最大的价值是dp[i][v]
        int[][] dp = new int[N+1][V+1];
        //base case
        for(int i = 0; i <= N;i++){
            //背包容量为0 价值为0
            dp[i][0] = 0;
        }
        for(int v = 0; v <= V;v++){
            //背包不装物品 价值为0
            dp[0][v] = 0;
        }
//        //状态转移
////        for(int i = 1; i <= N;i++){
////            for(int v = 1; v <= V;v++){
////                    //选择：装几个？0 1 2 3…… v/size[i]
////                    for(int k = 0;k <=  v/size[i-1];k++){
////                        dp[i][v] = c;
////                    }
////            }
////        }

//        //优化1：
//        for(int i = 1; i <= N;i++){
//            for(int v = size[i-1];v <= V;v++){
//                dp[i][v] = Math.max(dp[i-1][v],//没选第i个
//                        //选了一个第i个物品 在剩下的V-size[i-1]中继续选前i种物品
//                        dp[i][v-size[i-1]] + val[i-1]);
//            }
//        }

        //空间优化
        //最终用第i次循环结束后的dp[v]表示dp[i][v]
        //为了保证 每次循环开始时，取到的dp[v] 就是 dp[i][v]，采用顺序计算。
        int[] dp2 = new int[V+1];
        Arrays.fill(dp2,0);
        //循环到i<N为止 一共N个
        for(int i = 0; i < N;i++){
            for(int v = size[i];v <= V;v++) {
                dp2[v] = Math.max(dp2[v],dp2[v - size[i]] + val[i]);
            }
        }


        return dp2[V];
    }

     @Test
    public void test(){
        int V = 4;
        int N = 3;
        int[] size = {2,1,3};
        int[] val = {1,2,3};
        System.out.println(KnapsackFull(V,N,size,val));
        //System.out.println(Bag_SaveSpace(W,N,wt,val));
    }



}
