package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class Num1806 {
    static int[] arr;
    static int cnt;
    static int target;
    static int result = Integer.MAX_VALUE;
    static boolean isAble = false;

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
        int value = 0;
        int lastIndex = 0;

        for (int i = 0; i < cnt; i++) {
            while (value < target) {
                if (lastIndex >= cnt) {
                    if (!isAble) result = 0;
                    bw.write(result + "");
                    bw.flush();
                    return;
                }
                value += arr[lastIndex];
                lastIndex++;
            }
            isAble = true;
            if (result > lastIndex - i) result = lastIndex - i;
            value -= arr[i];
        }
        bw.write(result + "");
        bw.flush();
    }
}