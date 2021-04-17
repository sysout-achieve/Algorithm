package LeetCode.Practice;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] input = new int[]{2, 8, 11, 14};
        int target = 16;
        for (int i = 0; i < 2; i++) {
            System.out.print(solve(input, target)[i] + " ");
        }
    }


    //대안1. 이중for문
    //

    //대안2. HashMap
    //HashMap<int, int> -> <target-i, position>
    //for i
    // map 안에 값이 있는지 확인
    // 있으면 position 배열에 담아 결과값 전달
    static int[] solve(int[] input, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                return new int[]{map.get(input[i]), i};
            } else {
                map.put(target - input[i], i);
            }
        }
        return new int[]{0, 0};
    }


}
