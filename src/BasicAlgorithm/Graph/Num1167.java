package BasicAlgorithm.Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Num1167 {
    static Node[] tree;
    static int result = Integer.MIN_VALUE;
    static int start = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree = new Node[V + 1];
        ArrayList<Integer>[] treeNode = new ArrayList[V + 1];
        boolean[] visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            treeNode[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int next;
            tree[value] = new Node();
            while ((next = Integer.parseInt(st.nextToken())) != -1) {
                int distance = Integer.parseInt(st.nextToken());
                tree[value].nextCost.put(next, distance);
                treeNode[value].add(next);
            }
        }
        dfs(1, treeNode, visited, 0);
        visited = new boolean[V + 1];
        dfs(start, treeNode, visited, 0);
        System.out.print(result);
    }

    private static void dfs(int i, ArrayList<Integer>[] arr, boolean[] visited, int length) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j : arr[i]) {
            if (!visited[j]) {
                length += tree[i].nextCost.get(j);
                if (result <= length) {
                    result = length;
                    start = j;
                }
                dfs(j, arr, visited, length);
                length -= tree[i].nextCost.get(j);
            }
        }
    }

    static class Node {
        HashMap<Integer, Integer> nextCost;

        public Node() {
            nextCost = new HashMap<>();
        }
    }
}