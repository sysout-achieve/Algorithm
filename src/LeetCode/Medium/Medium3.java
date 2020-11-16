package LeetCode.Medium;

public class Medium3 {
    public static void main(String[] args) {
        System.out.print(solution(new int[]{1, 2, 3, 4}));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        boolean[] noPrime = new boolean[3001];
        noPrime[0] = true;
        noPrime[1] = true;
        for (int i = 2; i < 3001; i++) {
            for (int j = 2; j < 1501; j++) {
                if (i * j <= 3000) noPrime[i * j] = true;
            }
        }

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int value = nums[i] + nums[j] + nums[k];
                    if (value <= 3000) {
                        if (!noPrime[value]) answer++;
                    }
                }
            }
        }

        return answer;
    }
}
