package BasicAlgorithm.Practice;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solve(input));
    }
    //대안 1. dfs
    // 기준 string, 전체 검색(dfs) anagram 확인

    //대안 2. map<String, List<String>>
    // string으로 map에 데이터 있는지 체크(정렬된 것)
    // 없으면 input, 있으면 List에 추가
    static List<List<String>> solve(String[] input) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : input) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
