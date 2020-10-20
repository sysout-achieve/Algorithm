package BasicAlgorithm.Basic;

import java.io.*;
import java.util.StringTokenizer;

public class Num2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String value = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        long res = Long.parseLong(value, B);
        bw.write(res+"");
        bw.flush();
    }
}