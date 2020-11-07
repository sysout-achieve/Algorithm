package BasicAlgorithm.DivideConquer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Num2448 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        int value = new Scanner(System.in).nextInt();
        int col = value * 2 - 1;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        map = new int[value][col];
        divideConquer(0, 0, value, col);
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j]== 1){
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();

    }

    static void setStar(int row, int col, int rowLength, int colLength) {
        int midCol = ((colLength) / 2) + col;
        for (int i = 0; i < rowLength; i++) {
            map[row + i][midCol + i] = 1;
            map[row + i][midCol - i] = 1;
        }
        int i = 1;
        for (int j = col; j < col + colLength; j++) {
            if (i % 6 != 0) map[row + rowLength - 1][j] = 1;
            i++;
        }
    }

    static void divideConquer(int row, int col, int rowLength, int colLength) {
        setStar(row, col, rowLength, colLength);
        int midRow = (rowLength / 2);
        int midCol = (colLength / 2);
        int startCol = rowLength / 2 + col;
        if ((rowLength / 3) % 2 != 1) {
            divideConquer(row, startCol, midRow, midCol);
            divideConquer(row+midRow, col, midRow, midCol);
            divideConquer(row+midRow, col+midCol + 1, midRow, midCol);
        }
    }
}