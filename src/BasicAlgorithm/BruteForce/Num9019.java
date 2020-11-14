package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.*;

public class Num9019 {
    static String[] command;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        Vector<Integer> currentArr = new Vector<>();
        Vector<Integer> targetArr = new Vector<>();
        StringTokenizer st;

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            currentArr.add(Integer.parseInt(st.nextToken()));
            targetArr.add(Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            solve(currentArr.get(i), targetArr.get(i));
            sb.append(command[targetArr.get(i)] + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void solve(Integer cur, Integer target) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(cur);
        command = new String[10000];
        visited = new boolean[10000];
        command[cur] = "";
        while (!q.isEmpty()) {
            int value = q.poll();
            visited[value] = true;
            int D = (2 * value) % 10000;
            int S = (value == 0) ? 9999 : value - 1;
            int L = (value % 1000) * 10 + value / 1000;
            int R = (value % 10) * 1000 + value / 10;
            if (value == target) return;
            if (!visited[D]) {
                visited[D] = true;
                command[D] = command[value] + "D";
                q.offer(D);
            }
            if (!visited[S]) {
                visited[S] = true;
                command[S] = command[value] + "S";
                q.offer(S);
            }
            if (!visited[L]) {
                visited[L] = true;
                command[L] = command[value] + "L";
                q.offer(L);
            }
            if (!visited[R]) {
                visited[R] = true;
                command[R] = command[value] + "R";
                q.offer(R);
            }
        }
    }
}
