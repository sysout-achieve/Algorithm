package BasicAlgorithm.DivideConquer;

import java.io.*;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class Num11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        Vector<Long> v = new Vector<>();
        st = new StringTokenizer(br.readLine());
        int size = 0;
        for (int i = 0; i < N; i++) {
            v.add(Long.parseLong(st.nextToken()));
            size++;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            v.add(Long.parseLong(st.nextToken()));
            size++;
        }

        Collections.sort(v);
        long before = v.get(0);
        StringBuilder sb = new StringBuilder(before + " ");
        for (int i = 1; i < size; i++) {
            long value = v.get(i);
            sb.append(value + " ");

//            before = value;
        }
        bw.write(sb.toString());
        bw.flush();
    }
}