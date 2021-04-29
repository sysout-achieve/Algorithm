package LeetCode.Practice;

public class MaxSubarray {
    public static void main(String[] args) {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solve(input));
    }

    //sum = Math.max(sum+input[i], input[i])
    //max = Math.max(sum, max)
    private static int solve(int[] input) {
        int sum = input[0], max = input[0];

        for (int i = 1; i < input.length; i++) {
            sum = Math.max(sum + input[i], input[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

}
