package Algorithm.DynamicProgramming;

import org.junit.Test;

/**
 * @author songhuan
 * @date 2021/11/24 8:44
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 */
public class Fib {
    //原始递归方法
    int fib(int N){
        if(N == 1 | N == 2){
            return 1;
        }
        else {
            return fib(N - 1) + fib(N - 2);
        }
    }
    //自顶向下 构建一个备忘录 算过的结果存进去 以后用的时候去找
    int fib_improve(int n){
        int[] memo = new int[n+1];
        return helper(memo,n);
    }

    int helper(int[] memo,int n){
        if(n == 1 | n == 0){
            return n;
        }
        if (memo[n] != 0){
            return memo[n];
        }
        memo[n] = helper(memo,n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    int fib_dp(int n){
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n+1];
        //base case
        dp[0] = 0;
        dp[1] = 1;
        //状态转移
        for(int i = 2;i <= n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    @Test
    public void test(){
        System.out.println(fib_dp(20));
    }

}
