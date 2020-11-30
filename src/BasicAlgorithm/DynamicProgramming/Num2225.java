package BasicAlgorithm.DynamicProgramming;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int limit = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        long mod = 1000000000;
        long[][] dp = new long[cnt + 1][limit + 1];
        Arrays.fill(dp[1], 1);

        for (int i = 0; i <= cnt; i++) {
            dp[i][1] = i;
        }
        for (int i = 2; i <= cnt; i++) {
            for (int j = 2; j <= limit; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
            }
        }
        bw.write((dp[cnt][limit] % mod) + "");
        bw.flush();
    }
}
