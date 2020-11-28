package LeetCode.Medium;

public class Medium7_2 {
    static int[] w = {10, 20, 30};
    static int[] v = {60, 100, 120};
    static int k = 50;

    public static void main(String[] args) {
        System.out.print(knapsack(w, v, k));
    }

    public static int knapsack(int[] w, int[] v, int k) {
        int[][] dp = new int[w.length + 1][k + 1];
        int max = 0;
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (w[i - 1] <= j)
                    dp[i][j] = Math.max(v[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];

                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}