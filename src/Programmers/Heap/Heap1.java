package Programmers.Heap;

import java.util.PriorityQueue;

public class Heap1 {
    public static void main(String[] args) {
        System.out.print(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int i = 0; i < scoville.length; i++) {
            heap.offer(scoville[i]);
        }

        while (heap.peek() < K) {
            if (heap.size() == 1) return -1;
            int lowFirst = heap.poll();
            int lowSecond = heap.poll();
            int sum = sumScoville(lowFirst, lowSecond, K);
            heap.offer(sum);
            answer++;
        }
        return answer;
    }

    public static int sumScoville(int firstLow, int secondLow, int K) {
        return 2 * secondLow + firstLow;
    }
}
