package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class Num1182 {
    static int cnt;
    static int result = 0;
    static int target;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cnt = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        arr = new int[cnt + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (target == 0) result--;
        dfs(0, 0);
        bw.write(result + "");
        bw.flush();
    }

    private static void dfs(int currentIndex, long currentValue) {
        if (currentIndex == cnt) {
            if (currentValue == target) {
                result++;
            }
            return;
        }
        dfs(currentIndex + 1, currentValue + arr[currentIndex]);
        dfs(currentIndex + 1, currentValue);
    }
}