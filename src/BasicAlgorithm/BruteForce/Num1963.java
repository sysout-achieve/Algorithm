package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.*;

public class Num1963 {
    static int[] prime = new int[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        Vector<Integer> currentPwd = new Vector<>();
        Vector<Integer> targetPwd = new Vector<>();
        StringTokenizer st;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            currentPwd.add(Integer.parseInt(st.nextToken()));
            targetPwd.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 2; i < 10000; i++) {
            for (int j = 2; j < i/2; j++) {
                if(i % j == 0)
                    prime[i]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            int res = changePwd(currentPwd.get(i), targetPwd.get(i));
            if (res == -1) {
                sb.append("Impossible\n");
            } else {
                sb.append(res + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static int changePwd(int pwd, int target) {
        if (pwd == target) return 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(pwd);
        int[] visited = new int[10000];

        visited[pwd]++;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == target) return visited[target] - 1;
            for (int i = 0; i < 4; i++) {
                int value;
                for (int j = 0; j <= 9; j++) {
                    if (i == 0 && j == 0) continue;
                    value = changeDigit(now, i, j);
                    if (value < 100000 && value > 1000 && visited[value] == 0 && prime[value] == 0) {
                        q.offer(value);
                        visited[value] = visited[now] + 1;
                    }
                }
            }
        }
        return -1;
    }

    static int changeDigit(int num, int index, int v) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.setCharAt(index, (char) (v + '0'));
        return Integer.parseInt(sb.toString());
    }
}