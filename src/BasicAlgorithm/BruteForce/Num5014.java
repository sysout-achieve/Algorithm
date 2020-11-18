package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num5014 {
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int allCnt = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        if (target == start) {
            bw.write(0 + "");
            bw.flush();
            return;
        }
        visited = new int[allCnt + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = 1;
        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == target) break;
            int next1 = current + up;
            int next2 = current - down;
            if (next1 <= allCnt) {
                if (visited[next1] == 0) {
                    visited[next1] = visited[current] + 1;
                    q.offer(next1);
                }
            }
            if (next2 > 0) {
                if (visited[next2] == 0) {
                    q.offer(next2);
                    visited[next2] = visited[current] + 1;
                }
            }
        }
        if (visited[target] == 0)
            bw.write("use the stairs");
        else bw.write(visited[target] - 1 + "");
        bw.flush();
    }
}