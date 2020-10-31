package BasicAlgorithm.Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Num11725 {
    static int[] parent;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int lineCnt = sc.nextInt();

        ArrayList<Integer>[] arr = new ArrayList[lineCnt + 1];
        boolean[] visited = new boolean[lineCnt + 1];
        parent = new int[lineCnt + 1];
        for (int i = 1; i < lineCnt + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < lineCnt - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x].add(y);
            arr[y].add(x);
        }

        dfs(1, arr, visited);
        for (int i=2; i<=lineCnt; i++){
            System.out.print(parent[i]+"\n");
        }
    }

    private static void dfs(int i, ArrayList<Integer>[] arr, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j : arr[i]) {
            if (!visited[j]) {
                parent[j] = i;
                dfs(j, arr, visited);
            }
        }
    }
}
