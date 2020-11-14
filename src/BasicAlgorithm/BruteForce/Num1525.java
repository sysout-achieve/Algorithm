package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1525 {
    static int[] nx = {0, 0, 1, -1};
    static int[] ny = {1, -1, 0, 0};
    static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        start = 0;
        StringTokenizer st;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 0) value = 9;
                start = start * 10 + value;
            }
        }

        int result = bfs(start);
        bw.write(result + "");
        bw.flush();
    }

    static int bfs(int num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(num);
        map.put(num, 0);
        while (!q.isEmpty()) {
            int now = q.poll();
            int index = String.valueOf(now).indexOf("9");
            int x = index / 3;
            int y = index % 3;
            if (now == 123456789) {
                return map.get(now);
            }

            for (int i = 0; i < 4; i++) {
                int dx = x + nx[i];
                int dy = y + ny[i];
                int move = dx * 3 + dy;
                if (dx >= 0 && dx < 3 && dy >= 0 && dy < 3) {
                    StringBuilder next = new StringBuilder(String.valueOf(now));
                    char temp = next.charAt(move);
                    next.setCharAt(move, '9');
                    next.setCharAt(index, temp);
                    int nextNum = Integer.parseInt(next.toString());
                    if (!map.containsKey(nextNum)) {
                        map.put(nextNum, map.get(now) + 1);
                        q.offer(nextNum);
                    }
                }
            }
        }
        return -1;
    }

}