package BasicAlgorithm.Basic;

import java.io.*;

public class Num1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int size = input.length();
        boolean start = false;
        for (int i = 0; i < size; i++) {
            int value = input.charAt(i) - '0';
            int temp = value % 4;
            if (value / 4 >= 1) {
                sb.append(1);
                start =true;
            } else {
                if (i != 0) sb.append(0);
            }
            if (temp / 2 >= 1) {
                sb.append(1);
            } else {
                if (i != 0 || start) sb.append(0);
            }
            temp = temp % 2;
            sb.append(temp);
        }
        System.out.print(sb.toString());
        bw.flush();
    }
}