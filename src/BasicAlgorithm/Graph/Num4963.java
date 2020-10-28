package BasicAlgorithm.Graph;

import java.util.Scanner;

public class Num4963 {
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map;
        boolean[][] visited;
        while (true) {
            int line1 = sc.nextInt();
            int line2 = sc.nextInt();
            if (line1 == 0 && line2 == 0) {
                return;
            }
            map = new int[line1][line2];
            visited = new boolean[line1][line2];
            int res = 0;


            for (int j = 0; j < line2; j++) {
                for (int i = 0; i < line1; i++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int j = 0; j < line2; j++) {
                for (int i = 0; i < line1; i++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j, map, visited, line1, line2);
                        res++;
                    }
                }
            }
            System.out.print(res + "\n");
        }
    }

    static void dfs(int x, int y, int[][] map, boolean[][] visited, int line1, int line2) {
        if (map[x][y] == 0 || visited[x][y]) return;
        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < line1 && ny < line2 && map[nx][ny] == 1&& !visited[nx][ny]) {
                dfs(nx, ny, map, visited, line1, line2);
            }
        }
    }
}