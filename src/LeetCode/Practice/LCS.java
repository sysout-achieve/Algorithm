package LeetCode.Practice;

import java.util.Scanner;

public class LCS {
    //Longest Common Substring
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String b = scan.nextLine();

        int[][] LCS = new int[a.length() + 1][b.length() + 1];
        int answer = 0;
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                    answer = Math.max(answer, LCS[i][j]);
                    //일치하는 애들 중에서 가장 긴 부분 수열
                }
            }
        }

        for (int i = 0; i < LCS.length; i++) {
            for (int j = 0; j < LCS[0].length; j++) {
                System.out.print(LCS[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(answer);
    }
}
