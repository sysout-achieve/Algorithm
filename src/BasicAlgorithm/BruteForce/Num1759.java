package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.*;

public class Num1759 {
    static int size;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        int givenCnt = Integer.parseInt(st.nextToken());
        String[] alpha = br.readLine().split(" ");
        sb = new StringBuilder();
        Arrays.sort(alpha);
        bruteForce(alpha, "", 0);

        bw.write(sb.toString());
        bw.flush();
    }

    static void bruteForce(String[] alpha, String password, int index) {
        if (password.length() == size) {
            if (isPassword(password)) sb.append(password + "\n");
            return;
        }
        if (alpha.length <= index) return;

        bruteForce(alpha, password + alpha[index], index + 1);
        bruteForce(alpha, password, index + 1);
    }

    static boolean isPassword(String password) {
        int vowel = 0;
        int consonant = 0;
        for (char x : password.toCharArray()) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                vowel += 1;
            } else {
                consonant += 1;
            }
        }
        return vowel >= 1 && consonant >= 2;
    }
}