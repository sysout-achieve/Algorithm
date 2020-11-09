package BasicAlgorithm.DivideConquer;

import java.io.*;
import java.util.StringTokenizer;

public class Num1517 {
    static long result = 0;
    static long[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[cnt];
        sorted = new long[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        mergeSort(arr, 0, cnt - 1);

        System.out.println(result);
    }

    private static void mergeSort(long[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(long[] arr, int low, int mid, int high) {
        int index = low;
        int start = low;
        int start2 = mid + 1;

        while (start <= mid && start2 <= high) {
            if (arr[start] <= arr[start2]) {
                sorted[index++] = arr[start++];
            } else {
                sorted[index++] = arr[start2++];
                result += mid+1-start;
            }
        }
        while (start <= mid) sorted[index++] = arr[start++];

        while (start2 <= high) sorted[index++] = arr[start2++];


        for (int k = low; k <= high; k++) arr[k] = sorted[k];

    }
}