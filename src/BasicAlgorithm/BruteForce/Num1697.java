package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1697 {
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int move = Integer.parseInt(st.nextToken());
        int hide = Integer.parseInt(st.nextToken());
        int[] map = new int[100001];
        if (move >= hide) {
            bw.write(move - hide + "");
            bw.flush();
            return;
        }
        movePoint(move, hide, map);
        bw.write(result + "");
        bw.flush();
    }

    private static void movePoint(int move, int hide, int[] map) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(move);
        map[move] = 1;
        while (!q.isEmpty()) {
            int value = q.poll();
            for (int i = 0; i < 3; i++) {
                int temp;
                if (i == 0) {
                    temp = value - 1;
                } else if (i == 1) {
                    temp = value + 1;
                } else {
                    temp = value * 2;
                }
                if (temp == hide) {
                    result = map[value];
                    return;
                }
                if (temp >= 0 && temp <= 100000) {
                    if (map[temp] == 0) {
                        q.offer(temp);
                        map[temp] = map[value] + 1;
                    }
                }
            }
        }
    }
}