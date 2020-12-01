package BasicAlgorithm.SamsungSW;

import java.io.*;
import java.util.StringTokenizer;

public class Num14888 {
    static int cnt;
    static int[] arr;
    static long minRes = Long.MAX_VALUE;
    static long maxRes = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[cnt];
        int[] sign = new int[4];
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            sign[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, arr[0], sign[0], sign[1], sign[2], sign[3]);

        bw.write(maxRes + "\n" + minRes);
        bw.flush();
    }

    private static void solve(int index, long value, int plus, int minus, int multiply, int divide) {
        if (index == cnt - 1) {
            minRes = Math.min(minRes, value);
            maxRes = Math.max(maxRes, value);
            return;
        }
        if (plus != 0) solve(index + 1, value + arr[index + 1], plus - 1, minus, multiply, divide);
        if (minus != 0) solve(index + 1, value - arr[index + 1], plus, minus - 1, multiply, divide);
        if (multiply != 0) solve(index + 1, value * arr[index + 1], plus, minus, multiply - 1, divide);
        if (divide != 0) solve(index + 1, value / arr[index + 1], plus, minus, multiply, divide - 1);
    }
}