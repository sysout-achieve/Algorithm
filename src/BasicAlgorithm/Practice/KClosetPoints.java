package BasicAlgorithm.Practice;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosetPoints {
    public static void main(String[] args) {
        int[][] input = new int[][]{{3, 1}, {2, -2}, {6, 3}, {4, 5}};
        int k = 3;
        int x = solve(input, k)[0];
        int y = solve(input, k)[1];
        System.out.println("res : " + x + "," + y);
    }

    public static int[] solve(int[][] input, int k) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> ((a[0] * a[0]) + (a[1] * a[1])) - ((b[0] * b[0]) + (b[1] * b[1])));
        for (int[] point : input) {
            q.offer(point);
        }
        for (int i = 1; i < k; i++) {
            q.poll();
        }
        return q.poll();
    }
}
