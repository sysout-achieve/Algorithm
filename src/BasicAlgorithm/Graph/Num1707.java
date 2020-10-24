package BasicAlgorithm.Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Num1707 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase-- > 0) {
            int spot = sc.nextInt();
            int line = sc.nextInt();

            ArrayList<Integer>[] arr = new ArrayList[spot + 1];
            int[] color = new int[spot + 1];
            for (int i = 1; i < spot + 1; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 0; i < line; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[a].add(b);
                arr[b].add(a);
            }
            boolean isBiPartite = true;

            for (int i = 1; i <= spot; i++) {
                if (color[i] == 0) dfs(i, color, arr, 1);
            }
            for (int i = 1; i <= spot; i++) {
                for (int j : arr[i]) {
                    if (color[j] == color[i]) isBiPartite = false;
                }
            }
            if (isBiPartite) {
                System.out.print("YES\n");
            } else {
                System.out.print("NO\n");
            }

        }
    }

    private static void dfs(int num, int[] color, ArrayList<Integer>[] arr, int colorNum) {
        color[num] = colorNum;
        for (int i : arr[num]) {
            if (color[i] == 0) dfs(i, color, arr, 3 - colorNum);
        }
    }
}



/*
    public static void dfs(ArrayList<Integer>[] a, int[] color, int x, int c) {
        color[x] = c;
        for (int y : a[x]) {
            if (color[y] == 0) {
                dfs(a, color, y, 3 - c);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // testCase
        while (t-- > 0) {
            int n = sc.nextInt(); // 정점의 수
            int m = sc.nextInt(); // 간선의 수

            ArrayList<Integer>[] a = (ArrayList[]) new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) { // 정점만큼 배열 어레이리스트 생성
                a[i] = new ArrayList();
            }

            for (int i = 0; i < m; i++) {
                int part1 = sc.nextInt();
                int part2 = sc.nextInt();

                a[part1].add(part2);
                a[part2].add(part1);
            }

            int[] color = new int[n + 1]; // 정점의 방문 여부
            // 0 : 방문 X, 1 : part1 소속 방문O , 2: part2 소속 방문O
            boolean ok = true;

            for (int i = 1; i <= n; i++) {
                if (color[i] == 0) // 정점 i 방문 X인 상태라면,
                    dfs(a, color, i, 1);
            }
            for (int i = 1; i <= n; i++) {
                for (int j : a[i]) {
                    if (color[i] == color[j]) {
                        ok = false;
                    }
                }
            }
            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    */