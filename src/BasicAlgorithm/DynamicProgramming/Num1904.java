package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num1904 {
    public static void main(String[] args) {
        int cipher = new Scanner(System.in).nextInt();
        double[] dp = new double[cipher+5];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 3; i <= cipher; i++) {
            dp[i] = (dp[i-1]+ dp[i-2])%15746;
        }
        System.out.print((int) dp[cipher]+"");

    }
}
