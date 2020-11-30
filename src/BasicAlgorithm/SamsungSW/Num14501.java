package BasicAlgorithm.SamsungSW;

import java.io.*;
import java.util.*;

public class Num14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] dp = new int[cnt + 2];
        int[] time = new int[cnt + 1];
        int[] point = new int[cnt + 1];
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            time[i] = t;
            point[i] = p;
        }
        for (int i = cnt; i >= 0; i--) {
            if (i + time[i] - 1 <= cnt) {
                dp[i] = Math.max(point[i] + dp[i + time[i]], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        bw.write(dp[0] + "");
        bw.flush();
    }
}