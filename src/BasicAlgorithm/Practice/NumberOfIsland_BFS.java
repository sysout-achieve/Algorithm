package BasicAlgorithm.Practice;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIsland_BFS {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int col, row;
    static int result = 0;

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.print(solve(grid) + "");
    }

    public static int solve(char[][] map) {
        row = map[0].length;
        col = map.length;
        boolean[][] visited = new boolean[row+1][col+1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[j][i] && map[j][i] == '1') {
                    result++;
                    bfs(j, i, map, visited);
                }
            }
        }
        return result;
    }

    private static void bfs(int x, int y, char[][] map, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < col && ny < row) {
                    if (!visited[nx][ny] && map[nx][ny] == '1') {
                        q.offer(new int[]{nx, ny});
                    }
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
