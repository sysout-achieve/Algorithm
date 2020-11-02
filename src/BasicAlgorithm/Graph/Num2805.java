package BasicAlgorithm.Graph;

import java.io.*;
import java.util.StringTokenizer;

public class Num2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long end = 0;
        long start = 0;

        int treeCnt = Integer.parseInt(st.nextToken());
        long needLength = Integer.parseInt(st.nextToken());
        long[] trees = new long[treeCnt + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < treeCnt; i++) {
            long value = Long.parseLong(st.nextToken());
            trees[i] = value;
            start = Math.min(start, value);
            end = Math.max(end, value);
        }

        long res = 0;
        long mid = 0;
        while (end >= start || res < needLength) {
            res = 0;
            mid = (start + end) / 2;
            for (int i = 0; i < treeCnt; i++) {
                res += Math.max(trees[i] - mid, 0);
            }
            if (res >= needLength) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        bw.write(mid + "");
        bw.flush();
    }
}