package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num2579 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] arr = new int[cnt + 1];
        int[] dp = new int[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            arr[i] = scanner.nextInt();
        }
        dp[1] = arr[1];
        if (cnt >= 2) {
            dp[2] = Math.max(arr[1] + arr[2], arr[2]);
            for (int i = 3; i <= cnt; i++) {
                dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
            }
        }
        System.out.println(dp[cnt]);
    }
}
