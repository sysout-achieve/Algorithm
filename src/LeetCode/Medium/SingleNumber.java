package LeetCode.Medium;

import java.util.HashMap;
import java.util.Iterator;

public class SingleNumber {
    public static void main(String[] args) {
        singleNumber(new int[]{2,7,2,4,4});
    }
    /*
    1. 하나의 HashMap<>
    key -> 리스트에서 제거
    없으면 -> value에 key와 같은 값을 주입
    return map이 가지고 있는 value;
    시간복잡도 O(n)
    공간복잡도 O(n)

    2. 비트연산 XOR 특성을 이용해서 문제 해결
    n ^ n = 0;

    */
    //1번풀이
//    public int singleNumber(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i =0; i<nums.length; i++){
//            if(map.get(nums[i]) != null){
//                map.remove(nums[i]);
//            } else {
//                map.put(nums[i], nums[i]);
//            }
//        }
//        for (int i : map.keySet()){
//            return map.get(i);
//        }
//        return 0;
//    }
    //2번풀이

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
