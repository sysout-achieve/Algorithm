package LeetCode.Practice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MoveZeros2 {
    public static void main(String[] args) {
        int[] input = new int[]{0, -3, 2, 8, 0, 5, -6};
        // result = {3, 2, 8, 5, 0, 0}
        System.out.print(Arrays.toString(solve(input)) +"");
    }

    // 정수배열 숫자넣기
    // 결과값을 담을 result = int[]
    // result의 index를 저장할 변수 필요
    // input 순회하며 value 가 0이 아닐 경우만 result에 값 넣기 + (index++)
    // 시간복잡도는 O(n)
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
