package BasicAlgorithm.DynamicProgramming;

import java.util.*;

public class Num11726 {
    static int dp[];
    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        dp[1] =1;
        if(n>=2) dp[2]=2;
        for(int i=3;i<=n;i++) {
            dp[i] = dp[i-1]+ dp[i-2];
            dp[i] = dp[i] % 10007;
        }
        System.out.println(dp[n]);
    }
}
