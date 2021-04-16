package LeetCode.Practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {
        String input = "aabaacc";
        int result = solve(input.toCharArray());
        System.out.println(result);
    }

    //input을 순차적으로 탐색
    // int start
    // count가 2면 start 올려가면서 조건 탐색(HashMap에서 value가 1이면 -1 하면서 count--;
    //int result 값을 최대로 하는 결과값을 return;
    private static int solve(char[] input) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int result = 0;
        int count = 0;
        for (char c : input) {
            end++;
            if (map.get(c) == null){
                map.put(c, 1);
                count++;
            } else {
                map.replace(c, map.get(c)+1);
            }
            while (count > 2){
                if (map.get(input[start]) == 1){
                    map.remove(input[start]);
                    count--;
                } else {
                    map.replace(input[start], map.get(input[start])-1);
                }
                start++;
            }
            result = Math.max(end-start, result);
        }
        return result;
    }
}
