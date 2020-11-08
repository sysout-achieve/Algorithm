package BasicAlgorithm.DivideConquer;

import java.io.*;
import java.util.StringTokenizer;

public class Num1780 {
    static int[][] paper;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int line = Integer.parseInt(br.readLine());
        paper = new int[line][line];
        arr = new int[3];
        StringTokenizer st;
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < line; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }

        divideConquer(0, 0, line);
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0] + "\n" + arr[1] + "\n" + arr[2]);
        bw.write(sb.toString());
        bw.flush();
    }

    static boolean isPaper(int row, int col, int length) {
        int std = paper[row][col];
        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if (paper[i][j] != std) return false;
            }
        }
        return true;
    }

    static void divideConquer(int row, int col, int length) {
        if (isPaper(row, col, length)) {
            arr[paper[row][col]]++;
        } else {
            int newLength = length / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divideConquer(row + newLength * i, col + newLength * j, newLength);
                }
            }
        }
    }
}