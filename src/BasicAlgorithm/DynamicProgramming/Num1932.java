package BasicAlgorithm.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class Num1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        int[][] map = new int[cnt + 2][cnt + 2];
        int[][] dp = new int[cnt + 2][cnt + 2];
        StringTokenizer st;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][1] = map[0][1];
        for (int i = 1; i <= cnt; i++) {
            for (int j = 1; j <= i + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + map[i][j], dp[i - 1][j] + map[i][j]);
            }
        }
        int result = 0;
        for (int i = 0; i <= cnt; i++) {
            if (result < dp[cnt][i]) {
                result = dp[cnt][i];
            }
        }

        bw.write(result + "");
        bw.flush();
    }
}