package BasicAlgorithm.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Num17509 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] values = new int[11][2];
        for (int i =0; i<=10; i++){
            values[i][0] = sc.nextInt();
            values[i][1] = sc.nextInt();
        }

        int time =0;
        int result = 0;
        Arrays.sort(values, Comparator.comparingInt(o -> o[0]));

        for (int i =0; i<=10; i++){
            time += values[i][0];
            result += time+(20*values[i][1]);
        }
        System.out.println(result);
    }
}
