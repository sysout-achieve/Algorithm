package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num9465 {
    static int[][] cost;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCnt = scanner.nextInt();
        for (int t = 0; t < testCnt; t++) {
            int line = scanner.nextInt();
            cost = new int[line + 1][2];
            dp = new int[line + 1][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= line; j++) {
                    cost[j][i] = scanner.nextInt();
                }
            }
            dp[1][0] = cost[1][0];
            dp[1][1] = cost[1][1];
            for (int i = 2; i <= line; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + cost[i][0];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + cost[i][1];
            }
            System.out.println(Math.max(dp[line][1], dp[line][0]));
        }
        scanner.close();
    }
}

