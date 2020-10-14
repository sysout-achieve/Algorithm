package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num9461 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int[] req = new int[line];
        for (int i = 0; i < line; i++) {
            req[i] = scanner.nextInt();
        }
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 0; i < line; i++) {
            if (req[i] >= 6) {
                for (int j = 6; j <= req[i]; j++) {
                    dp[j] = dp[j - 1] + dp[j - 5];
                }
            }
            System.out.println(dp[req[i]]);
        }
    }
}
