package Algorithm.DynamicProgramming;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author songhuan
 * @date 2021/11/24 9:56
 * 0-1 背包问题
 * 一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]，
 * 现在让你用这个背包装物品，最多能装的价值是多少？
 *
 * 状态变化：val = dp[i][w] 当容量w的背包装了前i个物品时 最大的价值是val
 * 选择 第i个装不装？
 */
public class Bag01 {

    int Bag(int W,int N,int[] wt,int[] val){
        //注意： 第i个物品的重量是wt[i-1] 价值是val[i-1]
        //状态数组
        //状态变化：dp[i][w] 当容量w的背包装了前i个物品时 最大的价值是dp[i][w]
        int[][] dp = new int[N+1][W+1];
        //base case
        for(int i = 0; i <= N;i++){
            //背包容量为0 价值为0
            dp[i][0] = 0;
        }
        for(int w = 0; w <= W;w++){
            //背包不装物品 价值为0
            dp[0][w] = 0;
        }
        //状态转移
        for(int i = 1;i <= N;i++){
            for(int w = 1; w <= W;w++){
                if(w-wt[i - 1] < 0){
                    //剩余容量小于0 没法再装
                    dp[i][w] = dp[i-1][w];
                }
                else{
                    dp[i][w] = Math.max(
                            dp[i-1][w],//第i个物品没装
                            //第i个物品装了：找现在已有的容量w-第i个物品的容量的最大价值 再加上i的价值
                            dp[i - 1][w-wt[i - 1]] + val[i - 1]
                    );
                }

            }
        }
       return dp[N][W];
    }

    //二维数组转换为一维
    int Bag_SaveSpace(int W,int N,int[] wt,int[] val){
    //注意到每次求解 dp[i][v]只用到了上一行(i-1)的值：dp[i-1][v]  和 dp[i-1][ v-w[i] ]。
        // 考虑用dp[v]来表示之前dp[i][v]对应的状态。
        //第i次循环开始之前，dp [ j ] = dp [ i-1 ][ j ] ( 0<= j <= V )
        //第i次循环结束之后，dp [ j ] = dp [ i ][ j ]    ( 0<= j <= V )
        //那么在计算第i次循环的dp值时，两种选择变为下面的情况。
        //如果放弃物品i，即dp[i][v] = dp[i-1][v]，dp[v]保持不变即可。
        //如果放入物品i，即dp[i][v] = dp[i-1][ v-w[i] ]+ val[i - 1]， 很幸运，当前的dp[v-w[i]]就是dp[i-1][v-w[i]]。
        int[] dp = new int[W+1];
        Arrays.fill(dp,0);
        for(int i = 0;i < N;i++) {
            //注意：w是逆序
            //必须保证，在计算dp[v]的时候，dp[ v -w[i] ]依然等于dp[i-1][ v-w[i] ]
            //v是从小到大计算，dp[ v-w[i]] 已经在 dp[v]之前被计算过了。
            // 用到的dp[ v-w[i] ]是第i次循环计算出来的值。
            //代码相当于在执行：dp[ i ][ v ] = max{ dp[ i-1 ][ v ],dp[ i ][ v-w[i] ] };
            // (注意是dp[ i ][ v-w[i] ]！)
            for (int w = W; w >= wt[i]; w--)
            {
                dp[w] = Math.max(dp[w],dp[w - wt[i]] + val[i]);
            }
        }
        return dp[N];
    }

    @Test
    public void test(){
        int W = 4;
        int N = 3;
        int[] wt = {2,1,3};
        int[] val = {4,2,3};
        System.out.println(Bag(W,N,wt,val));
        System.out.println(Bag_SaveSpace(W,N,wt,val));
    }
}
