package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num1912 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] array = new int[cnt];
        int[] dp = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            array[i] = scanner.nextInt();
        }

        dp[0] = array[0];
        int maxValue = dp[0];
        for (int i = 1; i < cnt; i++) {
            dp[i] = Math.max(dp[i-1]+array[i], array[i] );
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(maxValue);
    }
}
