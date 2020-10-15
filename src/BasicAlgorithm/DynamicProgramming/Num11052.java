package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num11052 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[] pocket = new int[input + 1];
        int[] dp = new int[input + 1];
        for (int i = 1; i <= input; i++) {
            pocket[i] = scanner.nextInt();
        }

        for (int i = 1; i <= input; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j]+pocket[j]);
            }
        }
        System.out.println(dp[input]);
    }
}
