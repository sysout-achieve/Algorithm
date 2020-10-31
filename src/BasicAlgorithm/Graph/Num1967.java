package BasicAlgorithm.Graph;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Num1967 {
    static int result = 0;
    static int start = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int lineCnt = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[lineCnt + 1];
        TreeNode[] treeNode = new TreeNode[lineCnt + 1];
        int length = 0;
        StringTokenizer st;
        for (int i = 1; i <= lineCnt; i++) {
            treeNode[i] = new TreeNode();
        }
        for (int i = 1; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            treeNode[x].nodeCost.put(y, cost);
            treeNode[y].nodeCost.put(x, cost);
        }
        dfs(start, treeNode, visited, length);
        visited = new boolean[lineCnt+1];
        length = 0;
        dfs(start, treeNode, visited, length);
        System.out.print(result);
        bw.flush();
    }

    private static void dfs(int i, TreeNode[] tree, boolean[] visited, int length) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j : tree[i].nodeCost.keySet()) {
            if (!visited[j]){
                length+=tree[i].nodeCost.get(j);
                if (result<=length){
                    result = length;
                    start = j;
                }
                dfs(j, tree, visited, length);
                length-=tree[i].nodeCost.get(j);
            }
        }
    }
}

class TreeNode {
    HashMap<Integer, Integer> nodeCost;

    public TreeNode() {
        nodeCost = new HashMap<>();
    }

}