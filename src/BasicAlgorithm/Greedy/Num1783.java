package BasicAlgorithm.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Num1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        bw.write(solve(N, M) + "");
        bw.flush();
    }

    static int solve(int N, int M) {
        if (N == 1) return 1;
        if (N == 2) return Math.min(4, (M + 1) / 2);
        if (M < 7) return Math.min(4, M);
        return M - 2;
    }

}
