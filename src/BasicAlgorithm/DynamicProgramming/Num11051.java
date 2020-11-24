package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num11051 {
    static int[][] memo = new int[1001][1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        r = Math.max(r, n-r);

        System.out.println(comb(n, r));
    }

    static int comb(int n , int r) {
        for( int i = 1 ; i <= n ; i++) {
            memo[i][0] = 1;
            memo[i][i] = 1;
        }
        for( int i = 2 ; i <= n ; i++) {
            for( int j = 1 ; j < n ; j++) {
                memo[i][j] = (memo[i-1][j-1] + memo[i-1][j]) %10007;
            }
        }

        return memo[n][r];
    }
}