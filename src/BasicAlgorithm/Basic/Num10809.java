package BasicAlgorithm.Basic;

import java.io.*;

public class Num10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int[] list = new int[26];
        for (int i = 0; i < 26; i++) {
            list[i] = -1;
        }
        for (int i = 0; i < input.length(); i++) {
            char s = input.charAt(i);
            int num = (((int) s + 7) % 26);
            if (list[num] == -1) {
                list[num] = i;
            }
        }
        for (int i = 0; i < 26; i++) {
            bw.write(list[i] + " ");
        }
        bw.flush();
    }
}
