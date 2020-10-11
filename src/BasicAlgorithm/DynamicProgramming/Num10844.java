package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num10844 {
    public static void main(String[] args) {
        long[][] dp;
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        long result = 0;
        dp = new long[input + 1][11];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= input; i++) {
            dp[i][0] = dp[i-1][1];
            for (int j = 1; j <= 9; j++) {
                dp[i][j] = (dp[i - 1][j + 1] + dp[i - 1][j - 1]) % 1000000000;
            }
        }

        for (int i = 0; i <= 9; i++) {
            result += dp[input][i];
        }
        System.out.println(result % 1000000000);
    }
}