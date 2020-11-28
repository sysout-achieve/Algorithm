package LeetCode.Medium;

public class Medium9 {
    public static void main(String[] args) {
        System.out.print(solution(new int[]{5, 10, 7, 3, 8}));
    }

    public static int solution(int[] votes) {
        int maxIndex = -1;
        int max;
        int cost = 0;
        int len = votes.length;
        while (maxIndex != 0) {
            max = 0;
            for (int i = 0; i < len; i++) {
                if (votes[i] >= max) {
                    max = votes[i];
                    maxIndex = i;
                }
            }
            if (maxIndex == 0) break;
            votes[maxIndex]--;
            votes[0]++;
            cost++;
        }

        return cost;
    }

}
