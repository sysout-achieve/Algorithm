package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num11722 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] dp = new int[cnt];
        int[] arr = new int[cnt];
        for (int i =0; i<cnt; i++){
            arr[i] = scanner.nextInt();
            dp[i] = 1;
        }
        int result = 0;
        for (int i =0; i<cnt; i++){
            for (int j=0; j<=i; j++){
                if (arr[i]<arr[j] && dp[i]<=dp[j]){
                    dp[i] = dp[j]+1;
                }
            }
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}
