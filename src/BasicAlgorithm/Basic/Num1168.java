package BasicAlgorithm.Basic;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
        ArrayList<Integer> v = new ArrayList<>();

        for (int i = 1; i <= N; i++) v.add(i);

        int now = K - 1;
        int size = v.size();
        while (true) {
            SB.append(v.get(now));
            v.remove(now);
            size--;
            if (size == 0) break;
            SB.append(", ");
            now += K - 1;
            now %= size;
        }
        bw.write("<" + SB + ">");
        bw.flush();
    }
}
