package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2186 {
    static int[] nx = {1, -1, 0, 0};
    static int[] ny = {0, 0, 1, -1};
    static int row, col;
    static char[][] map;
    static int answer = 0;
    static int moveCnt;
    static int size;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        moveCnt = Integer.parseInt(st.nextToken());
        map = new char[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            String str = br.readLine();
            for (int j = 1; j <= col; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        String target = br.readLine();
        size = target.length() - 1;
        dp = new int[row * col + 1][size + 1];
        char firstChar = target.charAt(0);
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (map[i][j] == firstChar) dfs(i, j, 0, target);
            }
        }
//        bfs(target, size);       결과 나오지만 메모리 초과

        bw.write(answer + "");
        bw.flush();
    }

    static void dfs(int x, int y, int index, String target) {
        if (index == size) {
//            dp[(x * (col - 1)) + y][index] = ++;
            return;
        }

        char c = target.charAt(index + 1);
        boolean isAble = false;
        for (int i = 1; i <= moveCnt; i++) {
            for (int j = 0; j < 4; j++) {
                int dx = x + (i * nx[j]);
                int dy = y + (i * ny[j]);
                if (dx >= 0 && dy >= 0 && dx < row && dy < col && c == map[dx][dy]) {
                    if (dp[(dx * (col-1)) + dy][index] == -1) continue;
//                    else
                    dfs(dx, dy, index + 1, target);
                    isAble = true;
                }
            }
        }
        if (!isAble) {
            dp[(x * (col-1)) + y][index] = -1;
        }
    }

    static void bfs(String target, int size) {
        Queue<Point> q = new ArrayDeque<>();
        char firstChar = target.charAt(0);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == firstChar) q.offer(new Point(i, j, 0));
            }
        }

        while (!q.isEmpty()) {
            Point point = q.poll();
            if (point.index == size) {
                answer++;
            } else {
                char c = target.charAt(point.index + 1);
                for (int i = 1; i <= moveCnt; i++) {
                    for (int j = 0; j < 4; j++) {
                        int dx = point.x + (i * nx[j]);
                        int dy = point.y + (i * ny[j]);
                        if (dx >= 0 && dy >= 0 && dx < row && dy < col && c == map[dx][dy]) {
                            q.add(new Point(dx, dy, point.index + 1));
                        }
                    }
                }
            }
        }
    }
}

class Point {
    int x;
    int y;
    int index;

    public Point(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}