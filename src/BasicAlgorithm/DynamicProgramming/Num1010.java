package BasicAlgorithm.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class Num1010 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcCnt = Integer.parseInt(br.readLine());
        int[][] site = new int[tcCnt][2];
        dp = new int[31][31];
        StringTokenizer st;
        for (int i = 0; i < tcCnt; i++) {
            st = new StringTokenizer(br.readLine());
            site[i][0] = Integer.parseInt(st.nextToken());
            site[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= 30; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <= 30; i++) {
            for (int j = i; j <= 30; j++) {
                dp(i, j);
            }
        }
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < tcCnt; i++) {
            sb.append(dp[site[i][0]][site[i][1]]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void dp(int start, int end) {
        dp[start][end] = dp[start - 1][end - 1] + dp[start][end - 1];
    }
}