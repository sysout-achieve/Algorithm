package BasicAlgorithm.Basic;

import java.io.*;

public class Num10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";

        while ((input = br.readLine()) != null) {
            int[] list = new int[4];
            for (int i = 0; i < input.length(); i++) {
                char s = input.charAt(i);
                int value = s;
                if (value >= 97 && value <= 122) {
                    list[0]++;
                } else if (value >= 65 && value <= 90) {
                    list[1]++;
                } else if (value >= 48 && value <= 57) {
                    list[2]++;
                } else if (value == 32){
                    list[3]++;
                }
            }
            for (int i = 0; i < 4; i++) {
                bw.write(list[i] + " ");
            }
                bw.write("\n");
        }

        bw.flush();
    }
}

