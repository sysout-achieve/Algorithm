package Programmers.Stack;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queue2 {
    public static void main(String[] args) {

    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> q = new ArrayDeque<>();
        for (int i : priorities) {
            priorityQueue.offer(i);
            q.offer(i);
        }
        while (!q.isEmpty()) {
            if (priorityQueue.peek() == q.peek()) {
                priorityQueue.poll();
                q.poll();
                answer++;
                if (location == 0) {
                    break;
                } else {
                    location--;
                }
            } else {
                if (location == 0) {
                    location += q.size() - 1;
                } else {
                    location--;
                }
                q.offer(q.poll());
            }
        }
        return answer;
    }
}
