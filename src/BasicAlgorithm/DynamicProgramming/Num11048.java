package BasicAlgorithm.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class Num11048 {
    static int row, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int[][] map = new int[row+1][col+1];
        int[][] dp = new int[row+1][col+1];
        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = map[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        bw.write(dp[row][col] +"");
        bw.flush();
    }
}
