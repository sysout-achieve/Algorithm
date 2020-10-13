package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num11054 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] arr = new int[cnt];
        int[] dpAsc = new int[cnt];
        int[] dpDesc = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = scanner.nextInt();
            dpAsc[i] = 1;
            dpDesc[i] = 1;
        }

        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[i] > arr[j] && dpAsc[i] <= dpAsc[j]) {
                    dpAsc[i] = dpAsc[j] + 1;
                }
            }
        }
        for (int x = cnt - 1; x >= 0; x--) {
            for (int k = cnt - 1; k > x; k--) {
                if (arr[x] > arr[k] && dpDesc[x] <= dpDesc[k]) {
                    dpDesc[x] = dpDesc[k] + 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < cnt; i++) {
            result = Math.max(result, dpAsc[i] + dpDesc[i] - 1);
        }
        System.out.println(result);
    }
}
