package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num2011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int mod = 1000000;
        int[] dp = new int[input.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= input.length(); i++) {
            int now = i - 1;
            if (input.charAt(now) > '0') dp[i] = dp[i - 1];
            int prefValue = (input.charAt(now - 1) - '0') * 10 + (input.charAt(now) - '0');
            if (prefValue >= 10 && prefValue <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % mod;
            }
        }
        System.out.println(input.startsWith("0") ? 0 : dp[input.length()]);
    }
}
