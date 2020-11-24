package BasicAlgorithm.DynamicProgramming;

import java.io.*;

public class Num9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] c1, c2;
        String str = br.readLine();
        c1 = new char[str.length() + 1];
        for (int i = 1; i <= str.length(); i++) {
            c1[i] = str.charAt(i - 1);
        }
        str = br.readLine();
        c2 = new char[str.length() + 1];
        for (int i = 1; i <= str.length(); i++) {
            c2[i] = str.charAt(i - 1);
        }
        int[][] dp = new int[c2.length + 1][c1.length + 1];
        int result = 0;
        for (int i = 0; i < c2.length; i++) {
            for (int j = 0; j < c1.length; j++) {
                if (i - 1 < 0 || j - 1 < 0) {
                    dp[i][j] = 0;
                } else if (c1[j] == c2[i]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        result = dp[c2.length - 1][c1.length - 1];
        bw.write(result + "");
        bw.flush();
    }
}