package BasicAlgorithm.Graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BfsPractice {
    static int n;
    static int[] nx = {1, -1, 0, 0};
    static int[] ny = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int landNum = 0;
        int result = Integer.MAX_VALUE;
        n = sc.nextInt();
        int[][] land = new int[n][n];
        int[][] group = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                int input = sc.nextInt();
                land[i][j] = input;
                if (input == 1) {
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                Queue<int[]> groupQ = new ArrayDeque<>();
                if (land[i][j] == 1 && group[i][j] == 0) {
                    groupQ.offer(new int[]{i, j});
                    landNum++;
                    group[i][j] = landNum;
                    while (!groupQ.isEmpty()) {
                        int[] p = groupQ.remove();
                        for (int k = 0; k < 4; k++) {
                            int dx = p[0] + nx[k];
                            int dy = p[1] + ny[k];
                            if (dx >= 0 && dy >= 0 && dx < n && dy < n) {
                                if (land[dx][dy] == 1 && group[dx][dy] == 0) {
                                    group[dx][dy] = landNum;
                                    groupQ.offer(new int[]{dx, dy});
                                }
                            }
                        }
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] p =q.remove();
            for (int k = 0; k < 4; k++) {
                int dx = p[0] + nx[k];
                int dy = p[1] + ny[k];
                if (dx >= 0 && dy >= 0 && dx < n && dy < n) {
                    if (!visited[dx][dy]) {
                        group[dx][dy]= group[p[0]][p[1]];
                        q.offer(new int[]{dx, dy});
                        visited[dx][dy] = true;
                    }
                }
            }
        }


        System.out.print(result);
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print(land[i][j] + " ");
            }
            System.out.print("\n");
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print(group[i][j] + " ");
            }
            System.out.print("\n");
        }
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < n; i++) {
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.print("\n");
//        }
    }
}
