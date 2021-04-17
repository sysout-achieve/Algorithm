package LeetCode.Practice;

import java.util.PriorityQueue;

public class LargestElement {
    public static void main(String[] args) {
        int[] input = {1, 5, 7, 3, 2, 3, 4, 6, 8, 6};

        System.out.println(solve(input, 2));
    }

    //대안1. Sorting 해서 n-k번째 값 구하기
    // 시간복잡도 O(nLogn)

    //대안2. PriorityQueue -> (a,b)-> a-b
    // input 순회하면서 q size가 K개를 넘겼을 경우 한 개 뽑아냄
    // if(q.size>2)
    // q root 제거
    // return q.peek()
    // 시간복잡도 O(n)
    private static int solve(int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int i : input) {
            pq.offer(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }


}
