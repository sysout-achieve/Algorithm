package BasicAlgorithm.BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class Num1644 {
    static boolean[] prime;
    static int[] arr;
    static int result = 0;

    public static void main(String[] args) {
        int target = new Scanner(System.in).nextInt();
        int value = 0;

        prime = new boolean[target + 1];
        arr = new int[target + 1];
        Arrays.fill(prime, true);
        int index = 0;
        for (int i = 2; i <= target; i++) {
            for (int j = 2; j * i <= target; j++) {
                prime[i * j] = false;
            }
            if (prime[i]) {
                arr[index++] = i;
            }
        }
        int start = 0;
        int last = 0;
        for (int i = 0; i <= target; i++) {
            while (target > value) {
                if (last > index-1) break;
                value += arr[last];
                if (value == target) result++;
                last++;
            }
            value -= arr[start];
            if (value == target) result++;
            start++;
            if (start > last) break;
        }
        System.out.print(result + "");
    }
}
