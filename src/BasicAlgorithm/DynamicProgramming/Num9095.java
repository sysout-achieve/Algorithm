package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num9095 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCnt = scanner.nextInt();
        int[] testCase = new int[testCnt+1];
        int maximum =0;
        for (int i =0; i<testCnt; i++){
            int value=scanner.nextInt();
            testCase[i] = value;
            maximum = Math.max(maximum, value);
        }
        dp = new int[maximum+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i=0; i<testCnt; i++){
            solve(testCase[i]);
        }
    }

    public static void solve(int value){
//        if (dp[value] != 0){
            for (int i=4; i<=value; i++) {
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
            }

        System.out.println(dp[value]);
    }
}
