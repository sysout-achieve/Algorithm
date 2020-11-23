package BasicAlgorithm.DynamicProgramming;

import java.io.*;

public class Num2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        long[] dp = new long[count+4];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= count; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        bw.write(dp[count]+"");
        bw.flush();
    }
}
