package BasicAlgorithm.Practice;

import java.util.Stack;

public class DailyTemperature {
    static int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
    static int[] output = {1, 1, 4, 2, 1, 1, 0, 0};

    public static void main(String[] args) {
        int[] answer = solve(nums);
        for (int i = 0; i < nums.length; i++) System.out.print(answer[i] + " ");
    }

    public static int[] solve(int[] nums) {
        int length = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int temp = stack.pop();
                result[temp] = i - temp;
            }
            stack.push(i);
        }
        return result;
    }

    //대안 1. 이중반복문 계산
    //대안 2. stack 계산
    // if stack 없으면 stack에 바로 넣기
    // stack.peek() vs index Value 대소비교

}
