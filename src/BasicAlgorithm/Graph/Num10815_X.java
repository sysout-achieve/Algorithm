package BasicAlgorithm.Graph;

import java.io.*;
import java.util.StringTokenizer;

public class Num10815_X {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        long[] cardHolder = new long[100000000];
//        long[] cardHolderM = new long[100000000];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value >= 0) {
                cardHolder[value]++;
            } else {
                cardHolder[Math.abs(value)] += 10;
            }
        }
        int checkCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < checkCnt; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value >= 0) {
                sb.append(cardHolder[value] % 10 + " ");
            } else {
                sb.append(cardHolder[Math.abs(value)] / 10 + " ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}