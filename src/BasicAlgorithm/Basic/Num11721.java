package BasicAlgorithm.Basic;

import java.io.*;

public class Num11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String given = br.readLine();
        StringBuilder sb = new StringBuilder();
        int last = 0;
        for (int i = 0; i < given.length() / 10; i++) {
            sb.append(given, last, last + 10);
            sb.append("\n");
            last += 10;
        }
        sb.append(given.substring(last));
        bw.write(sb.toString());
        bw.flush();
    }
}