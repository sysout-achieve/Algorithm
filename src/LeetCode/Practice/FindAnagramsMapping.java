package LeetCode.Practice;

import java.util.HashMap;

public class FindAnagramsMapping {

    public static void main(String[] args) {
        int[] A = {11, 27, 45, 31, 50};
        int[] B = {50, 11, 31, 45, 27};
        int[] result = solve(A, B);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }

    //대안1. A, B 이중 순회
    // 시간 복잡도 O(n^2)

    // 대안2. HashMap 이용
    // target의 데이터 hashmap 에 담는다 for()
    // A에 해당하는 값을 찾아 포지션 return
    // 시간 복잡도 O(n)
    private static int[] solve(int[] input, int[] target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[input.length];
        for(int i =0 ; i<target.length; i++){
            map.put(target[i], i);
        }
        for (int i = 0; i < input.length; i++) {
            result[i] = map.get(input[i]);
        }
        return result;
    }
}
