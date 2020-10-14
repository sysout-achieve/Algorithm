package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num9461_2 {
    static long[] dp = new long[101];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int[] req = new int[line];
        for (int i = 0; i < line; i++) {
            req[i] = scanner.nextInt();
        }
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 0; i < line; i++) {
            if (req[i] >= 6) {
                solve(req[i]);
            }
            System.out.println(dp[req[i]]);
        }
    }

    static long solve(int n){
        if (dp[n]>0) return dp[n];
        dp[n] = solve(n-1)+ solve(n-5);
        return dp[n];
    }
}
