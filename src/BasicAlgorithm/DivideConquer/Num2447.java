package BasicAlgorithm.DivideConquer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Num2447 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb =new StringBuilder();
        int value = new Scanner(System.in).nextInt();

        map = new int[value + 1][value + 1];
        divideConquer(1, 1, value);

        for (int i = 1; i <= value; i++) {
            for (int j = 1; j <= value; j++) {
                if (map[i][j] == 0){
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

    static void divideConquer(int row, int col, int length) {
        int midStart = length / 3;
        int midEnd = (length / 3) * 2;
        for (int i = midStart + row; i < row + midEnd; i++) {
            for (int j = midStart + col; j < col + midEnd; j++) {
                map[i][j] = 1;
            }
        }

        if (midStart != 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divideConquer(row + (midStart * i), col + (midStart * j), midStart);
                }
            }
        }
    }
}
