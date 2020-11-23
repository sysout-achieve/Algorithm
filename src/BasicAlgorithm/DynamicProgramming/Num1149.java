package BasicAlgorithm.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class Num1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] house = new int[cnt][3];
        int[][] dp = new int[cnt + 1][3];
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < cnt; i++) {
            dp[i + 1][0] = Math.min(dp[i][1] + house[i][0], dp[i][2] + house[i][0]);
            dp[i + 1][1] = Math.min(dp[i][0] + house[i][1], dp[i][2] + house[i][1]);
            dp[i + 1][2] = Math.min(dp[i][0] + house[i][2], dp[i][1] + house[i][2]);
        }
        int result = Math.min(Math.min(dp[cnt][2], dp[cnt][1]), dp[cnt][0]);
        bw.write(result + "");
        bw.flush();
    }
}