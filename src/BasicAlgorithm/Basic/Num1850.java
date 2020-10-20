package BasicAlgorithm.Basic;

import java.io.*;
import java.util.StringTokenizer;

public class Num1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long input1 = Long.parseLong(st.nextToken());
        long input2 = Long.parseLong(st.nextToken());
        long result = gcd(input1, input2);
        StringBuilder sb = new StringBuilder();
        for (long i=0; i<result; i++){
            sb.append("1");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static long gcd (long x, long y){
        long tmp;
        while (y !=0){
            tmp = x%y;
            x = y;
            y = tmp;
        }
        return x;
    }
}