package BasicAlgorithm.Basic;

import java.io.*;

public class Num11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();
        String text = br.readLine();
        for (int i = 0; i < text.length(); i++) {
            int value = text.charAt(i);
            if (value >= 65 && value <= 90) {
                value += 13;
                if (value > 90) {
                    value -= 26;
                }
            }
            if (value >= 97) {
                value += 13;
                if (value > 122) {
                    value -= 26;
                }
            }
            stringBuilder.append((char) value);
        }
        bw.write(stringBuilder.toString());

        bw.flush();
    }


}
