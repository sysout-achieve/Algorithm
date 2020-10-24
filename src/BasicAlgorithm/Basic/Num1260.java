package BasicAlgorithm.Basic;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class Num1260 {
    static ArrayList<Integer>[] nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        boolean[] visitDFS = new boolean[N + 1];
        boolean[] visitBFS = new boolean[N + 1];
        nodeList = new ArrayList[N + 1];
        StringBuilder sbBFS = new StringBuilder();
        StringBuilder sbDFS = new StringBuilder();
        for (int i = 0; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodeList[a].add(b);
            nodeList[b].add(a);
        }
        for (int i = 0; i <= N; i++) {
            Collections.sort(nodeList[i]);
        }
        dfs(start, visitDFS, sbDFS);
        bfs(start, visitBFS, sbBFS);
        bw.write(sbDFS.toString() + "\n");
        bw.write(sbBFS.toString());

        bw.flush();
    }

    static void bfs(int start, boolean[] visit, StringBuilder bfs) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            if (visit[node]) continue;

            visit[node] = true;
            bfs.append(node + " ");
            for (int nextNode : nodeList[node]) {
                q.add(nextNode);
            }
        }
    }

    static void dfs(int start, boolean[] visit, StringBuilder dfs) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visit[node]) {
                dfs.append(node + " ");
            }
            visit[node] = true;
            for (int i = nodeList[node].size() - 1; i >= 0; i--) {
                if (visit[nodeList[node].get(i)]) continue;
                else {
                    stack.push(nodeList[node].get(i));
                }
            }
        }
    }
}