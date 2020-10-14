package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num1699 {
    public static void main(String[] args) {
        int value = new Scanner(System.in).nextInt();
        int[] dp = new int[value + 1];

        for (int i = 1; i <= value; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j]+1, dp[i]);
            }
        }
        System.out.println(dp[value]);
    }
}
