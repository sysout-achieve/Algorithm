package BasicAlgorithm.Graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Num2146 {
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
        int[][] dist = new int[n][n];
        Queue<int[]> distQ = new ArrayDeque<>();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                int input = sc.nextInt();
                land[i][j] = input;
                if (input == 0) {
                    dist[i][j] = -1;
                } else {
                    distQ.offer(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1 && group[i][j] == 0) {
                    Queue<int[]> q = new ArrayDeque<>();
                    group[i][j] = ++landNum;
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] p = q.remove();
                        int x = p[0], y = p[1];
                        for (int k = 0; k < 4; k++) {
                            int dx = x + nx[k], dy = y + ny[k];
                            if (0 <= dx && dx < n && 0 <= dy && dy < n)
                                if (land[dx][dy] == 1 && group[dx][dy] == 0) {
                                    q.add(new int[]{dx, dy});
                                    group[dx][dy] = landNum;
                                }
                        }
                    }
                }
            }
        }

        while (!distQ.isEmpty()) {
            int[] p = distQ.remove();
            int x = p[0], y = p[1];
            for (int k = 0; k < 4; k++) {
                int dx = x + nx[k];
                int dy = y + ny[k];
                if (0 <= dx && dx < n && 0 <= dy && dy < n) {
                    if (dist[dx][dy] == -1) {
                        dist[dx][dy] = dist[x][y] + 1;
                        group[dx][dy] = group[x][y];
                        distQ.offer(new int[]{dx, dy});
                    }
                }
            }
        }


        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {

                for (int k = 0; k < 4; k++) {
                    int dx = i + nx[k];
                    int dy = j + ny[k];
                    if (0 <= dx && dx < n && 0 <= dy && dy < n) {
                        if (group[dx][dy] != group[i][j]) result = Math.min(result, dist[dx][dy] + dist[i][j]);
                    }
                }
            }
        }

        System.out.print(result);
        System.out.print("\n");
//        System.out.print("\n");
//        System.out.print("\n");
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < n; i++) {
//                System.out.print(land[i][j] + " ");
//            }
//            System.out.print("\n");
//        }
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < n; i++) {
//                System.out.print(group[i][j] + " ");
//            }
//            System.out.print("\n");
//        }
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < n; i++) {
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.print("\n");
//        }
    }
}
//
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.LinkedList;
//        import java.util.Queue;
//        import java.util.StringTokenizer;
//
//public class Num2146 {
//    public static int[] dx = {0, 0, 1, -1};
//    public static int[] dy = {1, -1, 0, 0};
//
//    public static void main(String args[]) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int[][] inputArr = new int[n][n];
//        int[][] distArr = new int[n][n];
//        int[][] groupArr = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < n; j++) {
//                inputArr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        int cnt = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (inputArr[i][j] == 1 && groupArr[i][j] == 0) { //a가 1이고 g를 초기화 안했다면
//                    Queue<Dot> q = new LinkedList<Dot>();
//                    groupArr[i][j] = ++cnt; //g를 초기화
//                    q.add(new Dot(i, j));
//                    while (!q.isEmpty()) {
//                        Dot p = q.remove();
//                        int x = p.x, y = p.y;
//                        for (int k = 0; k < 4; k++) {
//                            int nx = x + dx[k], ny = y + dy[k];
//                            if (0 <= nx && nx < n && 0 <= ny && ny < n)
//                                if (inputArr[nx][ny] == 1 && groupArr[nx][ny] == 0) {
//                                    q.add(new Dot(nx, ny));
//                                    groupArr[nx][ny] = cnt;
//                                }
//                        }
//                    }
//                }
//            }
//        }
//
//        Queue<Dot> q = new LinkedList<Dot>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                distArr[i][j] = -1;
//                if (inputArr[i][j] == 1) {
//                    q.add(new Dot(i, j));
//                    distArr[i][j] = 0;
//                }
//            }
//        }
//        while (!q.isEmpty()) {
//            Dot p = q.remove();
//            int x = p.x, y = p.y;
//            for (int k = 0; k < 4; k++) {
//                int nx = x + dx[k], ny = y + dy[k];
//                if (0 <= nx && nx < n && 0 <= ny && ny < n)
//                    if (distArr[nx][ny] == -1) {
//                        distArr[nx][ny] = distArr[x][y] + 1;
//                        groupArr[nx][ny] = groupArr[x][y];
//                        q.add(new Dot(nx, ny));
//                    }
//            }
//        }
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < n; i++) {
//                System.out.print(inputArr[j][i]+" ");
//            }
//            System.out.print("\n");
//        }
//            System.out.print("\n");
//            System.out.print("\n");
//
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < n; i++) {
//                System.out.print(distArr[j][i]+" ");
//            }
//            System.out.print("\n");
//        }
//            System.out.print("\n");
//            System.out.print("\n");
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < n; i++) {
//                System.out.print(groupArr[j][i]+" ");
//            }
//            System.out.print("\n");
//        }
//            System.out.print("\n");
//            System.out.print("\n");
////        int ans = Integer.MAX_VALUE;
////        for (int i = 0; i < n; i++) {
////            for (int j = 0; j < n; j++) {
////                for (int k = 0; k < 4; k++) {
////                    int x = i + dx[k];
////                    int y = j + dy[k];
////                    if (0 <= x && x < n && 0 <= y && y < n) {
////                        if (groupArr[i][j] != groupArr[x][y]) ans = Math.min(ans, distArr[i][j] + distArr[x][y]);
////                    }
////                }
////            }
////        }
////        System.out.println(ans);
//    }
//
//    private static class Dot {
//        int x;
//        int y;
//
//        public Dot(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//}