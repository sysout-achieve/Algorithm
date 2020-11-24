package BasicAlgorithm.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class Num1520 {
    static int[] nx = {1, -1, 0, 0};
    static int[] ny = {0, 0, 1, -1};
    static int[][] map;
    static long[][] dp;
    static int row, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row + 1][col + 1];
        dp = new long[row + 1][col + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move(1, 1);

        bw.flush();
    }

    private static void move(int row1, int col1) {
        int value = map[row1][col1];
        long cnt = dp[row1][col1];
        for (int i = 0; i < 4; i++) {
            int moveRow = row1 + ny[i];
            int moveCol = col1 + nx[i];
            if (moveRow > 0 && moveRow <= row && moveCol > 0 && moveCol < col) {
                if (value > map[moveRow][moveCol]){
                    dp[moveRow][moveCol]++;
                }
            }
        }
    }
}