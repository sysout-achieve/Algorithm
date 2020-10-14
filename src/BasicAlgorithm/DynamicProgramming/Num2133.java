package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num2133 {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        int[] dp = new int[N + 1];

        if (N % 2 != 0) {
            System.out.println(0);
            return;
        }
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        if (N > 2) {
            for (int i = 4; i <= N; i = i + 2) {
                dp[i] = dp[i - 2] * 3;
                for (int j = 0; j < i - 2; j = j + 2) {
                    dp[i] += dp[j] * 2;
                }
            }
        }
        System.out.println(dp[N]);
    }
}
