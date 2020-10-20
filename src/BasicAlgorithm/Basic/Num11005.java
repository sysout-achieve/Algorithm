package BasicAlgorithm.Basic;

import java.io.*;
import java.util.StringTokenizer;

public class Num11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long value = Long.parseLong(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        String N =Long.toString(value, B).toUpperCase();
        bw.write(N);
        bw.flush();
    }
}