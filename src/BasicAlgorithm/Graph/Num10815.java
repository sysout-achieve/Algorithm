package BasicAlgorithm.Graph;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Num10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> cardHolder = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            int value = Integer.parseInt(st.nextToken());
            cardHolder.put(value, 1);
        }
        int checkCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < checkCnt; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (cardHolder.get(value) != null) {
                sb.append(cardHolder.get(value) + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
