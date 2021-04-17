package LeetCode.Practice;

public class LIS {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 2, 5, 2, 6, 10, 4, 12, 13, 8, 9, 10, 11, 11};
        System.out.println(solve(input));
    }


    //대안 input 순회
    // 직전 index까지 다시 순회
    // input[현재] > input[index] (dp[index]+1)의 최대값을 input[현재] 에 담습니다.
    // return dp[]순회하여 최대값
    private static int solve(int[] input) {
        int[] dp = new int[input.length];
        dp[0] = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if(input[j] <= input[i]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            result = Math.max(dp[i], result);
        }

        return result;
    }


}
