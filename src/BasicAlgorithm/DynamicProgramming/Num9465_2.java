package BasicAlgorithm.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class Num9465_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            int col = Integer.parseInt(br.readLine());
            int[][] map = new int[col+1][2];
            int[][] dp = new int[col+1][2];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= col; k++) {
                    map[k][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[1][0] = map[1][0];
            dp[1][1] = map[1][1];
            for (int j = 2; j <= col; j++) {
                dp[j][0] = Math.max(dp[j-2][1], dp[j-1][1])+map[j][0];
                dp[j][1] = Math.max(dp[j-2][0], dp[j-1][0])+map[j][1];
            }
            sb.append(Math.max(dp[col][0], dp[col][1])+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}