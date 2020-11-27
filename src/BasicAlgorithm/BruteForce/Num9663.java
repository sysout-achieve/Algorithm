package BasicAlgorithm.BruteForce;

import java.io.*;

public class Num9663 {
    public static int[] arr;
    public static int N;
    public static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        nQueen(0);
        System.out.println(count);
    }

    private static void nQueen(int col) {
        if (col == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[col] = i ;
            if (isPossible(col)) nQueen(col+ 1);
        }
    }

    private static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) return false;
            else if (Math.abs(arr[col]- arr[i]) == Math.abs(col -i)) return false;
        }
        return true;
    }
}