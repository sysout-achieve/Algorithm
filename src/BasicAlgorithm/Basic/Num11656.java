package BasicAlgorithm.Basic;

import java.io.*;
import java.util.Arrays;

public class Num11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] strArray = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            strArray[i] = s.substring(i);
        }
        Arrays.sort(strArray);
        for(String str : strArray) {
            bw.write(str);
            bw.write('\n');
        }
        bw.flush();
    }
}