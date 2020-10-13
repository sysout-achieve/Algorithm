package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num11053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] arr = new int[cnt];
        int[] dp = new int[cnt];
        int result = 0;
        for (int i = 0; i < cnt; i++) {
            arr[i] = scanner.nextInt();
            dp[i] = 1;
        }

        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
