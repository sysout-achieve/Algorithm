package LeetCode.Medium;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums)
            if (i == 0 || num > nums[i - 1]) {
                nums[i++] = num;
            }
        return i;
    }
}
