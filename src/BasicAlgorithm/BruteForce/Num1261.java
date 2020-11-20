package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.*;

public class Num1261 {
    static int row, col;
    static int[][] map;
    static int[] nx = {1, -1, 0, 0};
    static int[] ny = {0, 0, 1, -1};
    static boolean[][] visited;
    static PriorityQueue<Ground> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        visited = new boolean[row][col];
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        q = new PriorityQueue<>();
        bfs(0, 0);
    }


    private static void bfs(int x, int y) {
        Ground temp = new Ground(x, y, map[x][y]);
        q.offer(temp);
        while (!q.isEmpty()) {
            Ground ground = q.poll();
            if (visited[ground.x][ground.y]) continue;
            visited[ground.x][ground.y] = true;
            int cost = ground.cost;
            if (ground.x == row - 1 && ground.y == col - 1) {
                System.out.println(ground.cost + "");
                return;
            }
            for (int i = 0; i < 4; i++) {
                int dx = ground.x + nx[i];
                int dy = ground.y + ny[i];
                if (dx >= 0 && dy >= 0 && dx < row && dy < col) {
                    if (!visited[dx][dy]) {
                        q.offer(new Ground(dx, dy, map[dx][dy] + cost));
                    }
                }
            }
        }
    }
}

class Ground implements Comparable<Ground> {
    int x, y;
    int cost;

    public Ground(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Ground o) {
        return cost - o.cost;
    }
}