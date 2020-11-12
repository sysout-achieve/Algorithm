package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class Num10971 {
    static int result = Integer.MAX_VALUE;
    static int[][] cost;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());

        cost = new int[cnt + 1][cnt + 1];
        int[] moveArr = new int[cnt + 1];
        visited = new boolean[cnt + 1];
        StringTokenizer st;
        for (int i = 1; i <= cnt; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= cnt; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
            moveArr[i] = i;
        }

        permutation(moveArr, 2, cnt);
        bw.write(result + "");
        bw.flush();
    }


    static void permutation(int[] arr, int depth, int cnt) {
        if (depth == cnt) {
            findCost(arr, cnt);
            return;
        }

        for (int i = depth; i < cnt + 1; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, cnt);
            swap(arr, depth, i);
        }

    }

    private static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static void findCost(int[] moveArr, int cnt) {
        int temp = 0;
        int sum = 0;
        for (int i = 1; i < cnt; ++i) {
            temp = cost[moveArr[i]][moveArr[i + 1]];
            if (temp == 0) return;
            sum += temp;
        }
        if (cost[moveArr[cnt]][1] == 0) return;
        sum += cost[moveArr[cnt]][1];
        if (sum < result) result = sum;
    }
}