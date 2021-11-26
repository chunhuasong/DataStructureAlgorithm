package Algorithm.DynamicProgramming;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author songhuan
 * @date 2021/11/24 9:18
 * 凑零钱问题
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，
 * 再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1
 */
public class CoinChange {
    //O(k * n^k)
    // coins 中是可选硬币面值，amount 是目标金额
    int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }
    //求每个子问题需要多少个硬币
    int dp(int[] coins,int amount){

        if(amount == 0)
            return 0;
        if(amount < 0)
            return -1;

        int num = Integer.MAX_VALUE;
        //遍历所有面值
        for(int coin : coins){
            int subnum = dp(coins,amount - coin);
            if(subnum == -1){
                //跳出本次循环
                continue;
            }
            num = Math.min(num,subnum + 1);
        }
        return num == Integer.MAX_VALUE? -1 : num;
    }

    int coinChange_improve(int[] coins, int amount){
        int[] dp = new int[amount + 1];//防止后面1 + dp[i - coin] 整型溢出
        // 数组大小为 amount + 1，初始值也为 amount + 1
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    @Test
    public void test(){
        int[] coins ={1,2,5};
        int amount = 6;
        System.out.println(coinChange(coins,amount));

    }

}
