package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class Num1451 {
    static long[][] sum;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] map = new int[row+1][col+1];
        sum = new long[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            String str = br.readLine();
            for (int j = 1; j <= col; j++) {
                map[i][j] = str.charAt(j-1) - '0';
            }
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + (long) map[i][j];
            }
        }
        long rec1;
        long rec2;
        long rec3;
        for (int i = 1; i <= row - 2; i++) {
            for (int j = i + 1; j <= row - 1; j++) {
                rec1 = sum(1, 1, i, col);
                rec2 = sum(i + 1, 1, j, col);
                rec3 = sum(j + 1, 1, row, col);
                getResult(rec1*rec2*rec3);
            }
        }

        for (int i = 1; i <= col - 2; i++) {
            for (int j = i + 1; j <= col - 1; j++) {
                rec1 = sum(1, 1, row, i);
                rec2 = sum(1, i + 1, row, j);
                rec3 = sum(1, j + 1, row, col);
                getResult(rec1*rec2*rec3);

            }
        }

        for (int i = 1; i <= row - 1; i++) {
            for (int j = 1; j <= col - 1; j++) {
                rec1 = sum(1, 1, i, col);
                rec2 = sum(i + 1, 1, row, j);
                rec3 = sum(i + 1, j + 1, row, col);
                getResult(rec1*rec2*rec3);

                rec1 = sum(1, 1, i, j);
                rec2 = sum(i + 1, 1, row, j);
                rec3 = sum(1, j + 1, row, col);
                getResult(rec1*rec2*rec3);

                rec1 = sum(1,1 , row, j);
                rec2 = sum(1,j+1, i, col);
                rec3 = sum(i+1,j+1, row, col);
                getResult(rec1*rec2*rec3);

                rec1 = sum(1,1,i,j);
                rec2 = sum(1, j+1,i,col);
                rec3 = sum(i+1,1, row, col);
                getResult(rec1*rec2*rec3);
            }
        }

        bw.write(result+"");
        bw.flush();
    }

    static long sum(int startRow, int startCol, int endRow, int endCol) {
        return sum[endRow][endCol] - sum[endRow][startCol - 1] - sum[startRow - 1][endCol] + sum[startRow - 1][startCol - 1];
    }

    static void getResult(long sum){
        if (result<sum){
            result = sum;
        }
    }
}