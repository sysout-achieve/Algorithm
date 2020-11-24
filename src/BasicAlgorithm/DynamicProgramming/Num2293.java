package BasicAlgorithm.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class Num2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] coin = new int[cnt + 1];
        int[] dp = new int[target + 1];

        for (int i = 0; i < cnt; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for (int i = 0; i < cnt; i++) {
            for (int j = coin[i]; j <= target; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }
        bw.write(dp[target] + "");
        bw.flush();
    }
}