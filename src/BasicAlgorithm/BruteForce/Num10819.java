package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class Num10819 {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());

        int[] arr = new int[cnt + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
        }
        permutation(arr, 0, cnt);
        bw.write(result + "");
        bw.flush();
    }

    static void permutation(int[] arr, int depth, int cnt) {
        if (depth == cnt) return;

        for (int i = depth; i < cnt; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, cnt);
            findMax(arr, cnt);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public static void findMax(int[] arr, int cnt) {
        int temp = 0;
        int sum = 0;
        for (int i = 0; i < cnt - 1; ++i) {
            temp = Math.abs(arr[i] - arr[i + 1]);
            sum += temp;
        }
        if (sum > result) result = sum;
    }
}