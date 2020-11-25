package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class Num14719 {
    static int[] map;
    static int left, right;
    static int maxLeft, maxRight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalHeight = Integer.parseInt(st.nextToken());
        int totalWidth = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        map = new int[totalWidth];
        for (int i = 0; i < totalWidth; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        left = 0;
        right = totalWidth - 1;
        maxLeft = map[left];
        maxRight = map[right];
        int result = 0;
        while (left < right) {
            if (maxLeft < maxRight) {
                result += goRight(left, right);
            } else {
                result += goLeft(left, right);
            }
        }
        bw.write(result+"");
        bw.flush();
    }

    static int goRight(int start, int end) {
        int water = 0;
        for (int i = start + 1; i <= end; i++) {
            if (map[start] <= map[i]) {
                maxLeft = map[i];
                left = i;
                return water;
            }
            water += map[start] - map[i];
        }
        return water;
    }

    static int goLeft(int start, int end) {
        int water = 0;
        for (int i = end - 1; i >= start; i--) {
            if (map[end] <= map[i]) {
                maxRight = map[i];
                right = i;
                return water;
            }
            water += map[end] - map[i];
        }
        return water;
    }
}