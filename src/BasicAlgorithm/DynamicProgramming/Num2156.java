package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num2156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bottle = scanner.nextInt();
        int[] dp = new int[bottle+1];
        int[] point = new int[bottle+1];
        for (int i =0; i<bottle; i++){
            dp[i] = scanner.nextInt();
        }
        if (bottle ==1){
            System.out.println(dp[0]);
            return;
        }
        point[0] = dp[0];
        point[1] = dp[1] + point[0];
        point[2] = Math.max(Math.max(point[0]+dp[2], point[1]), dp[1]+dp[2]);
        for (int i =3; i<bottle; i++){
            point[i] = Math.max(Math.max(point[i-2]+dp[i], point[i-1]), point[i-3]+dp[i]+dp[i-1]);
        }

        System.out.println(point[bottle-1]);
    }
}
