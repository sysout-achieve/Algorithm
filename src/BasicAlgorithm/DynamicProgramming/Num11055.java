package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num11055 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        long[] arr = new long[cnt + 1];
        long[] dp = new long[cnt + 1];
        long max = 0;
        for (int i = 1; i <= cnt; i++) {
            arr[i] = scanner.nextInt();
            dp[i] = arr[i];
        }
        for (int i = 1; i <= cnt; i++) {
            for (int j = 1; j < i; j++)
                if (arr[j] < arr[i] && dp[i] < dp[j] + arr[i]) dp[i] = dp[j] + arr[i];
            if (max < dp[i]) max = dp[i];
        }
        System.out.println(max);
    }
}