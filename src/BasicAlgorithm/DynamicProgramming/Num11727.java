package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num11727 {
    public static void main(String[] args) {
        int cnt = new Scanner(System.in).nextInt();
        double mod = 10007;
        double[] dp = new double[cnt + 5];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= cnt; i++) {
            dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % mod;
        }
        System.out.print(((int)dp[cnt] + ""));
    }
}
