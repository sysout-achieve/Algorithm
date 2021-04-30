package LeetCode.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        ArrayList<ArrayList<String>> result = solve(input);
        System.out.println(result);
    }

    private static ArrayList<ArrayList<String>> solve(String[] input) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String s : input) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String valueStr = Arrays.toString(temp);
            if (map.get(valueStr) != null) {
                map.get(valueStr).add(s);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(valueStr, list);
            }
        }
        return new ArrayList<>(map.values());
    }


}
