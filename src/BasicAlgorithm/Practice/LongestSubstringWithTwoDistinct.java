package BasicAlgorithm.Practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithTwoDistinct {
    public static void main(String[] args) {
        String input = "ccccaabb";
        System.out.println(solve(input) + "");

    }

    public static int solve(String input) {
        int index = 0, count = 0, start = 0, end = 0;
        char[] chars = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        while (index < input.length()) {
            map.put(chars[index], map.getOrDefault(chars[index], 0) + 1);
            if (map.get(chars[index]) == 1) count++;
            end++;
            while (count > 2) {
                map.put(chars[start], map.get(chars[start]) - 1);
                if (map.get(chars[start]) == 0) count--;
                start++;
            }
            result = Math.max(result, end - start);
            index++;
        }
        return result;
    }
}
