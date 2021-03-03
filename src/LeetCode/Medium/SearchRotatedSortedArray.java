package LeetCode.Medium;

public class SearchRotatedSortedArray {
    //대안 1. 단순 반복
    // array를 순회하며 target 찾기
    // 없으면 -1, 있을 때 return idx
    // 시간복잡도 O(n) 공간복잡도 O(n)
    public int search(int[] nums, int target) {
        int size = nums.length;
        int result = 0;
        for(int num : nums){
            if(num == target){
                return result;
            }
            result++;
        }
        return -1;
    }
}
