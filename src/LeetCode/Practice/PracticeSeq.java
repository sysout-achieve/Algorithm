package LeetCode.Practice;

public class PracticeSeq {
    public static void main(String[] args) {
        String first = "abcded";
        String sec = "abecdeddddddd";
        solve(first.toCharArray(), sec.toCharArray());
    }

    private static int solve(char[] first, char[] sec) {
        int[][] result = new int[first.length + 1][sec.length + 1];
        int res = 0;
        for (int i = 1; i < first.length + 1; i++) {
            for (int j = 1; j < sec.length + 1; j++) {
                if (first[i - 1] == sec[j - 1]) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
                res = Math.max(res, result[i][j]);
            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print(res + "");
        return res;
    }
}
