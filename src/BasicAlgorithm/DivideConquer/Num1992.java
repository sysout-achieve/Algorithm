package BasicAlgorithm.DivideConquer;

import java.io.*;

public class Num1992 {
    static int[][] map;
    static StringBuilder sb;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        arr = new int[2];
        sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < size; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        divideConquer(0, 0, size);
        bw.write(sb.toString());
        bw.flush();
    }

    static boolean isCompressible(int row, int col, int length) {
        int std = map[row][col];
        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if (std != map[i][j]) return false;
            }
        }
        return true;
    }

    static void divideConquer(int row, int col, int length) {
        if (isCompressible(row, col, length)) {
            sb.append(map[row][col]);
        } else {
            int nLength = length / 2;
            sb.append("(");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    divideConquer(row + nLength * i, col + nLength * j, nLength);
                }
            }
            sb.append(")");
        }

    }
}