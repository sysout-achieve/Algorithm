package BasicAlgorithm.Basic;

import java.io.*;

public class Num11653 {
    static int[] prime = new int[10000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        primeCon(input);
        solve(input);
    }

    static void primeCon(int num) {
        for (int i = 2; i < num; i++) {
            if (prime[i] != 0) continue;
            for (int j = i * 2; j < num; j += i) {
                if (prime[j] == 0) {
                    prime[j]++;
                }
            }
        }
    }

    static void solve(int num) {
        for (int i = 2; i <= num; i++) {
            if (prime[i] == 0 && num%i==0){
                System.out.print(i+"\n");
                if (num/i !=1) solve(num/i);
                return;
            }
        }
    }
}