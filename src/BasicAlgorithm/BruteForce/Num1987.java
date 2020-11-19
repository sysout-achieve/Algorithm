package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class Num1987 {
    static char[][] map;
    static int[] nx = {1, -1, 0, 0};
    static int[] ny = {0, 0, 1, -1};
    static int row, col;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        boolean[] visited = new boolean[27];
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }
        dfs(0, 0, visited, 1);
        bw.write(result + "");
        bw.flush();
    }

    private static void dfs(int i, int j, boolean[] visited, int cnt) {
        visited[map[i][j] - 'A'] = true;
        for (int k = 0; k < 4; k++) {
            int dx = j + nx[k];
            int dy = i + ny[k];
            if (dx >= 0 && dx < col && dy >= 0 && dy < row) {
                if (!visited[map[dy][dx] - 'A']) dfs(dy, dx, visited, cnt + 1);
            }
        }
        visited[map[i][j] - 'A'] = false;
        if (result < cnt) {
            result = cnt;
        }
    }
}