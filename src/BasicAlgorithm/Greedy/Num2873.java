package BasicAlgorithm.Greedy;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num2873 {
    static int row, col;
    static int minX, minY;
    static int currentRow, currentCol;
    static int destinationRow, destinationCol;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int[][] map = new int[row][col];
        sb = new StringBuilder();
        int min = Integer.MAX_VALUE;
        minX = 0;
        minY = 0;
        currentRow = 0;
        currentCol = 0;
        destinationRow = row - 1;
        destinationCol = col - 1;
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (((j % 2 == 1 && i % 2 == 0) || (i % 2 == 1 && j % 2 == 0)) && min > value) {
                    min = value;
                    minY = i;
                    minX = j;
                }
            }
        }

        if (row % 2 == 1) {
            allPass(row, col, "R", "L", "D");
            bw.write(sb.toString());
            bw.flush();
            return;
        } else if (col % 2 == 1) {
            allPass(col, row, "D", "U", "R");
            bw.write(sb.toString());
            bw.flush();
            return;
        }

        while (currentRow < minY) {
            for (int x = 0; x < col - 1; x++) {
                if (currentCol == 0) {
                    sb.append("R");
                } else {
                    sb.append("L");
                }
            }
            if (currentCol == 0) {
                currentCol = col - 1;
            } else {
                currentCol = 0;
            }
            sb.append("D");
            currentRow++;
        }
        Stack<String> stack = new Stack();
        while (destinationRow > minY + 1) {
            for (int x = 0; x < col - 1; x++) {
                if (destinationCol == 0) {
                    stack.push("L");
                } else {
                    stack.push("R");
                }
            }
            if (destinationCol == 0) {
                destinationCol = col - 1;
            } else {
                destinationCol = 0;
            }
            stack.push("D");
            destinationRow--;
        }
        boolean isDown = true;
        if (currentCol == 0) {
            moveDown(currentCol, currentRow, "D", "R", "U", isDown, 1);
        } else {
            moveDown(currentCol, currentRow, "D", "L", "U", isDown, -1);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void moveDown(int currentCol, int currentRow, String str1, String str2, String str3, boolean isDown, int addNum) {
        if (currentCol == destinationCol && currentRow == destinationRow) return;
        if (currentCol < 0 && currentCol > col && currentRow < 0 && currentRow > row) return;

        currentRow++;
        if (currentCol == minX && currentRow == minY) {
            currentRow--;
            moveCol(currentCol, currentRow, str1, str2, str3, !isDown, addNum);
            return;
        }
        sb.append(str1);
        moveCol(currentCol, currentRow, str1, str2, str3, isDown, addNum);
    }

    private static void moveCol(int currentCol, int currentRow, String str1, String str2, String str3, boolean isDown, int addNum) {
        if (currentCol == destinationCol && currentRow == destinationRow) return;
        if (currentCol < 0 && currentCol > col && currentRow < 0 && currentRow > row) return;
        currentCol += addNum;
        sb.append(str2);
        if (isDown) {
            isDown = false;
            moveUp(currentCol, currentRow, str1, str2, str3, isDown, addNum);
        } else {
            isDown = true;
            moveDown(currentCol, currentRow, str1, str2, str3, isDown, addNum);
        }
    }

    private static void moveUp(int currentCol, int currentRow, String str1, String str2, String str3, boolean isDown, int addNum) {
        if (currentCol == destinationCol && currentRow == destinationRow) return;
        if (currentCol < 0 && currentCol > col && currentRow < 0 && currentRow > row) return;
        currentRow--;
        if (currentCol == minX && currentRow == minY) {
            currentRow++;
            moveCol(currentCol, currentRow, str1, str2, str3, !isDown, addNum);
            return;
        }
        sb.append(str3);
        moveCol(currentCol, currentRow, str1, str2, str3, isDown, addNum);
    }


    static void allPass(int x, int y, String str1, String str2, String str3) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y - 1; j++) {
                if (i % 2 == 1) {
                    sb.append(str2);
                } else {
                    sb.append(str1);
                }
            }
            if (i != x - 1) sb.append(str3);
        }
    }
}