package LeetCode.Practice;

import java.util.ArrayList;
import java.util.HashMap;

public class FindAllAnagrams {
    public static void main(String[] args) {
        String text = "BACDGABCDA";
        String pat = "ABCD";

        ArrayList<Integer> result = solve(text.toCharArray(), pat.toCharArray());
        System.out.println(result);

    }

    // 반복문 index = 0 -> text.length-pat.length
    //
    // Anagram 확인 true -> result.add(index)
    //              false ->
    //

    // Anagram 확인로직
    // 대안1. 문자열 정렬 -> equals 비교 같으면 anagram
    // 시간복잡도 : O(nLogn)
    // 대안2. pat을 HashMap -> <key(character), value(갯수)>
    //      확인하고자 하는 char찾아서 value-1
    //      value == 0 remove
    //      hashmap.size == 0이면 아나그램
    // 시간복잡도 : O(n)
    // pat.len = m
    // text.len = n
    // m+(m+m+m)*(n)
    // O(mn)

    private static ArrayList<Integer> solve(char[] text, char[] pattern) {
        ArrayList<Integer> result = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : pattern) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < text.length - pattern.length + 1; i++) {
            char[] temp = new char[pattern.length];
            System.arraycopy(text, i, temp, 0, pattern.length + i - i);
            HashMap<Character, Integer> tempMap = new HashMap<>(map);
            if (isAnagram(temp, tempMap)) result.add(i);
        }
        return result;
    }

    private static boolean isAnagram(char[] temp, HashMap<Character, Integer> map) {
        for (char c : temp) {
            if (map.getOrDefault(c, 0) == 1) {
                map.remove(c);
            } else {
                map.put(c, map.getOrDefault(c,0) - 1);
            }
        }
        return map.size() == 0;
    }


}
