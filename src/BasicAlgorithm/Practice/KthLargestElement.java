package BasicAlgorithm.Practice;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] input = {3,2,3,1,2,4,5,5,6};
        int k =  1;
        System.out.println(solve(input,k));
    }
    //대안 1. Array 담고 sorting -> length-k번째 배열 꺼냄
    //시간복잡도 O(n), 공간복잡도 O(n)

    //대안 2. priorityQueue에 k 만큼 담고 넘어 갈 경우 poll(); -> 가장 큰 k개만큼만 남김
    // q의 맨 위의 값 return
    //시간복잡도 O(n), 공간복잡도 O(n)
    static int solve(int[] input, int k){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i : input){
            q.offer(i);
            if (q.size() > k){
                q.poll();
            }
        }
        return q.peek();
    }
}
