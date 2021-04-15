package LeetCode.Practice;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] input = new int[]{0, 3, 2, 8, 0, 5};
        // result = {3, 2, 8, 5, 0, 0}
        System.out.print(Arrays.toString(solve(input)) +"");
    }

    // 정수배열 숫자넣기
    // 결과값을 담을 result = int[]
    // result의 index를 저장할 변수 필요
    // input 순회하며 value 가 0이 아닐 경우만 result에 값 넣기 + (index++)
    // 시간복잡도는 O(n)
    static int[] solve(int[] input){
        int index = 0;
        for (int i : input) {
            if (i != 0) {
                input[index] = i;
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
