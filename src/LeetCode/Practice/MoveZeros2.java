package LeetCode.Practice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MoveZeros2 {
    public static void main(String[] args) {
        int[] input = new int[]{0, -3, 2, 8, 0, 5, -6};
        // result = {3, 2, 8, 5, 0, 0}
        System.out.print(Arrays.toString(solve(input)) +"");
    }

    static int[] solve(int[] input){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int index = 0;
        for (int i : input){
            q.offer(i);
        }
        while (!q.isEmpty()){
            int temp = q.poll();
            if (temp != 0){
                input[index] = temp;
                index++;
            }
        }
        while (index < input.length){
            input[index] = 0;
            index++;
        }
        return input;
    }
}
