package BasicAlgorithm.Basic;

import java.io.*;

public class Num2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = br.readLine().length();
        bw.write(cnt+"");

        bw.flush();
    }
}
