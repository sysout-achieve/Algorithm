package BasicAlgorithm.Practice;

import java.util.HashMap;
import java.util.Map;

public class FindAnagrams {
    public static void main(String[] args) {
        int[] input = {11, 27, 45, 31, 50};
        int[] target = {50, 11, 31, 45, 27};

        int[] output = { 1, 4, 3, 2, 0};
        int[] result = solve(input, target);
        for (int i = 0; i< input.length; i++){
            System.out.println("res :" +result[i]);
        }
    }
    // 대안 1. hashMap을 이용
    // 배열에 하나씩 데이터 저장하는 방식
    // 시간복잡도  O(n), O(n)

    // 대안 2. input의 데이터를 for문으로 target에서 검색
    // 시간복잡도 O(n*n), 공간복잡도 O(n)
    public static int[] solve(int[] input, int[] target){
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[input.length];
        for(int i = 0; i < target.length; i++){
            map.put(target[i], i);
        }
        int index = 0;
        for (int num: input){
            result[index] = map.getOrDefault(num, 0);
            index++;
        }
        return result;
    }
}
