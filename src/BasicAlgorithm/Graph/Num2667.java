package BasicAlgorithm.Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Num2667 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int line;
    static int houseCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        line = Integer.parseInt(br.readLine());
        int[][] map = new int[line + 1][line + 1];
        boolean[][] visited = new boolean[line + 1][line + 1];
        int res = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < line; i++) {
            String input = br.readLine();
            for (int j = 0; j < line; j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    houseCnt =0;
                    res++;
                    dfs(i, j, map, visited);
                    arr.add(houseCnt);
                }
            }
        }
        bw.write(res+"\n");
        Collections.sort(arr);
        for (int i=0; i<res; i++){
            bw.write(arr.get(i)+"\n");
        }
        bw.flush();
    }

    static void dfs(int x, int y, int[][] map, boolean[][] visited) {
        if (visited[x][y]) return;
        visited[x][y] = true;
        if (map[x][y] == 0) return;
        houseCnt++;
        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];
            if (moveX >= 0 && moveY >= 0 && moveX < line && moveY < line && map[moveX][moveY] == 1) {
                dfs(moveX, moveY, map, visited);
            }
        }
    }
}