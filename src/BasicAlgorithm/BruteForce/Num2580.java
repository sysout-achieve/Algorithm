package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2580 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        map = new int[10][10];

        StringTokenizer st;
        Queue<Space> q = new ArrayDeque<>();
        for (int i = 1; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value == 0) {
                    q.offer(new Space(value, i, j));
                }
            }
        }
        sudoku(1, 1);
//        while (!q.isEmpty()) {
//            Space space = q.poll();
//            if (!findRightNumber(space)) q.offer(space);
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i =1; i<10; i++){
//            for (int j =1; j<10; j++){
//                sb.append(map[i][j]+" ");
//            }
//            sb.append("\n");
//        }
//        bw.write(sb.toString());
//        bw.flush();
    }

    static void sudoku(int row, int col) {
        // 해당 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
        if (col == 10) {
            sudoku(row + 1, 1);
            return;
        }

        // 행과 열이 모두 채워졌을 경우 출력 후 종료
        if (row == 10) {
            StringBuilder sb = new StringBuilder();
            for (int i =1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    sb.append(map[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            // 출력 뒤 시스템을 종료한다.
            System.exit(0);
        }

        // 만약 해당 위치가 0 이라면 1부터 9까지 중 가능한 수 탐색
        if (map[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                // i 값이 중복되지 않는지 검사
                if (findRightNumber(new Space(i, row, col))) {
//                    map[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            map[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);
    }

    public static boolean checkCol(Space space) {
        for (int i = 1; i < 10; i++) {
            if (map[space.row][i] == space.value) return false;
        }
        return true;
    }

    public static boolean checkRow(Space space) {
        for (int i = 1; i < 10; i++) {
            if (map[i][space.col] == space.value) return false;
        }
        return true;
    }

    public static boolean checkRec(Space space) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[space.getStartRow() + i][space.getStartCol() + j] == space.value) return false;
            }
        }
        return true;
    }

    public static boolean findRightNumber(Space space) {
            if (checkCol(space) && checkRow(space) && checkRec(space)) {
                map[space.row][space.col] = space.value;
                return true;
            }

        return false;
    }

}

class Space {
    int value;
    int row, col;

    public Space(int value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }

    public int getStartRow() {
        return (((row - 1) / 3) * 3) + 1;
    }

    public int getStartCol() {
        return (((col - 1) / 3) * 3) + 1;
    }

}