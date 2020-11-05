package BasicAlgorithm.Basic;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class Num1168 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder SB = new StringBuilder();
        Vector<Integer> v = new Vector<>();

        for (int i = 1; i <= N; i++) v.add(i);

        int now = K - 1;
        while (true) {
            SB.append(v.get(now));
            v.remove(now);
            if (v.size() == 0) break;
            SB.append(", ");
            now += K - 1;
            now %= v.size();
        }
        bw.write("<" + SB + ">");
        bw.flush();
    }
}
