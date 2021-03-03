package LeetCode.Medium;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int lastIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) nums[lastIndex++] = nums[i];
        }
        return lastIndex;
    }
}
