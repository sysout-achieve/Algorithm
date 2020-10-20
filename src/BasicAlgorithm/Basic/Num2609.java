package BasicAlgorithm.Basic;

import java.io.*;
import java.util.StringTokenizer;

public class Num2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long input1 = Integer.parseInt(st.nextToken());
        long input2 = Integer.parseInt(st.nextToken());
        long gcd = gcd(input1, input2);
        bw.write(gcd+"\n");
        bw.write(lcm(input1*input2, gcd)+"\n");

        bw.flush();
    }

    static long gcd(long x, long y) {
        long temp;
        while (y != 0) {
            temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }

    static long lcm(long value, long gcd){
        return value/gcd;
    }
}
