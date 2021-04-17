package LeetCode.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        ArrayList<ArrayList<String>> result = solve(input);
        System.out.println(result);
    }

    private static ArrayList<ArrayList<String>> solve(String[] input) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            char[] temp = input[i].toCharArray();
            Arrays.sort(temp);
            String valueStr = Arrays.toString(temp);
            if (map.get(valueStr) != null){
                map.get(valueStr).add(input[i]);
            } else {
                ArrayList<String> list = new ArrayList<>();
               list.add(input[i]);
               map.put(valueStr, list);
            }
        }
        result.addAll(map.values());
        return result;
    }


}
