package Programmers.Hash;

import java.util.Arrays;
import java.util.HashMap;

import static java.util.stream.Collectors.*;

public class Hash3 {
    public static void main(String[] args) {
        solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String[] clothe : clothes) {
            String key = clothe[1];
            int value = hashMap.getOrDefault(key, 0);
            hashMap.put(key, ++value);
        }

        for (String s : hashMap.keySet()) {
            int value = hashMap.get(s);
            answer *= value+1;
        }

        return answer-1;
    }

    //함수형풀이
//    public int solution(String[][] clothes){
//        return Arrays.stream(clothes)
//                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
//                .values()
//                .stream()
//                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
//    }
}
