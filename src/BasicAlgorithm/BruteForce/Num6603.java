package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class Num6603 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] map;
        sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            if (cnt == 0) break;
            map = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, map, "", cnt, 0);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int i, int[] map, String answer, int range, int size) {
        if (size == 6) {
            sb.append(answer + "\n");
            return;
        }
        if (i >= range) return;
        dfs(i + 1, map, answer + (map[i] + " "), range, size + 1);
        dfs(i + 1, map, answer, range, size);
    }
}