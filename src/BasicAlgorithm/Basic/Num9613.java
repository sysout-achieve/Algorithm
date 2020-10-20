package BasicAlgorithm.Basic;

import java.io.*;
import java.util.StringTokenizer;

public class Num9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] list;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int inputCnt = Integer.parseInt(st.nextToken());
            list = new int[inputCnt];
            for (int j = 0; j < inputCnt; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }
            long result = 0;
            for (int k = 0; k < inputCnt - 1; k++) {
                int compareIndex = k + 1;
                while (compareIndex != inputCnt) {
                    result += gcd(list[k], list[compareIndex]);
                    compareIndex++;
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
    }

    static int gcd(int x, int y) {
        int tmp;
        while (y != 0) {
            tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }
}