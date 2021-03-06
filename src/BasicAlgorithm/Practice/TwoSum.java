package BasicAlgorithm.Practice;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //input int[]{2,7,11,15} target =9
    //output return int[]{1,2}
    public static void main(String[] args) {
        System.out.println(solution2(new int[]{2, 7, 11, 15}, 9)[1]);
    }
    //시간복잡도 O(N^2), 공간복잡도 O(N)
    public static int[] solution1(int[] given, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < given.length - 1; i++) {
            answer[0] = i + 1;
            for (int j = i; j < given.length; j++) {
                if (given[i] + given[j] == target) {
                    answer[1] = j + 1;
                    return answer;
                }
            }
        }
        return new int[]{0, 0};
    }

    //시간복잡도 O(N), 공간복잡도 O(N)
    public static int[] solution2(int[] given, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < given.length - 1; i++) {
            if (map.containsKey(given[i])) {
                answer[0] = map.get(given[i]) + 1;
                answer[1] = i + 1;
                return answer;
            } else {
                map.put(target - given[i], i);
            }
        }
        return new int[]{0, 0};
    }

    //대안 1. 이중반복문
    // int[] answer
    // i -> i+1을 answer[0]
    // j -> 두 값의 합==target, j+1을 answer[1]
    //

    //대안 2. map 이용하기
    // map에 key(필요한 값), value(idx)
    // 반복문으로 map에 i 가 포함되어있는지 확인
    // 포함된다면 return int[]{value+1, i+1};
}
