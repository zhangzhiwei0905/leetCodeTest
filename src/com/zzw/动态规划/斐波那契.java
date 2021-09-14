package com.zzw.动态规划;

public class 斐波那契 {
    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(betterFib(10));
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 优化算法  不用dp数组
    public static int betterFib(int n) {
        if (n == 0) {
            return 0;
        }
        int prev = 0;
        int curr = 1;
        int tmp = 0;
        for (int i = 2; i <= n; i++) {
            tmp = prev + curr;
            prev = curr;
            curr = tmp;
        }
        return tmp;
    }
}
