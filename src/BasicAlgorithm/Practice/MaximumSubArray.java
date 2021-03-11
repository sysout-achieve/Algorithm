package BasicAlgorithm.Practice;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("res : "+solve(input));
    }

    public static int solve(int[] input) {
        int continuesMaximum = input[0];
        int result = input[0];
        for (int i = 1; i < input.length; i++) {
            continuesMaximum = Math.max(input[i], continuesMaximum + input[i]);
            result = Math.max(continuesMaximum, result);
        }
        return result;
    }
}
