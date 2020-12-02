package BasicAlgorithm.Basic;

import java.io.*;
import java.util.StringTokenizer;

public class Num1168_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder SB = new StringBuilder();
        boolean[] visited = new boolean[N + 1];

        int remainder = 0;
        int size = 0;
        int out = 0;

        for (int j = 1; j <= N; j++) {
            int jump = K - remainder - out;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    if (jump == 1) {
                        SB.append(i + "");
                        jump = K - remainder;
                        size++;
                        out = 0;
                        visited[i] = true;
                        if (size == N){
                            break;
                        }
                        SB.append(", ");
                    } else {
                        jump--;
                        out++;
                    }
                }
            }
        }
        bw.write("<" + SB + ">");
        bw.flush();
    }
}