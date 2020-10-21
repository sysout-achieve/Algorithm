package BasicAlgorithm.Basic;

import java.io.*;
import java.util.StringTokenizer;

public class Num1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = 0;
        for (int i = 0; i < cnt; i++) {
            int N = Integer.parseInt(st.nextToken());
            if (isPrime(N)) res++;
        }
        bw.write(res + "");
        bw.flush();
    }
    static boolean isPrime(int num){
        if (num<2) return false;
        for (int i=2; i<num; i++){
            if (num%i ==0) return false;
        }
        return true;
    }
}