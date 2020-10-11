package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num2193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        long[][] dp = new long[line + 1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;
        if (line >= 2) {
            for (int i = 2; i <= line; i++) {
                dp[i][1] = dp[i - 1][0];
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            }
        }
        System.out.println(dp[line][0] + dp[line][1]);
    }
}
