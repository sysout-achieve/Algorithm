package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class Num2003 {
    static int[] arr;
    static int cnt;
    static int target;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cnt = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        arr = new int[cnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < cnt; i++) {
            dfs(i, 0);
        }
        bw.write(result + "");
        bw.flush();
    }

    private static void dfs(int index, int value) {
        if (value > target) return;
        if (value == target) {
            result++;
            return;
        }

        if (index >= cnt) return;
        dfs(index + 1, value + arr[index]);
    }
}