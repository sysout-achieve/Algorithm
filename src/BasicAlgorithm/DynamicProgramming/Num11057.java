package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num11057 {
    public static void main(String[] args) {
        long[][] array;
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        array = new long[input + 1][11];
        for (int i = 0; i <= 9; i++) {
            array[1][i] = 1;
        }
        for (int i = 2; i <= input; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    array[i][j] += (array[i - 1][k]%10007);
                }
            }
        }
        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result += array[input][i];
        }
        System.out.println(result%10007);
    }
}
