package BasicAlgorithm.Graph;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lineY = Integer.parseInt(st.nextToken());
        int lineX = Integer.parseInt(st.nextToken());
        int[][] map = new int[lineX][lineY];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < lineY; i++) {
            String str = br.readLine();
            for (int j = 0; j < lineX; j++) {
                map[j][i] = str.charAt(j) - '0';
            }
        }
        q.offer(new int[]{0, 0});
        int[] nx = {0, 0, 1, -1};
        int[] ny = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            int[] point = q.remove();
            for (int i = 0; i < 4; i++) {
                int dx = point[0] + nx[i];
                int dy = point[1] + ny[i];
                if (dx >= 0 && dy >= 0 && dx < lineX && dy < lineY && map[dx][dy] == 1) {
                    q.offer(new int[]{dx, dy});
                    map[dx][dy] = map[point[0]][point[1]] + 1;
                }
            }
        }
        System.out.print(map[lineX-1][lineY-1] + " ");
    }
}