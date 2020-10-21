package BasicAlgorithm.Basic;


import java.io.*;
import java.util.StringTokenizer;

public class Num2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long fiveCnt = countFiveExponent(N) - countFiveExponent(K) - countFiveExponent(N - K);
        long twoCnt = countTwoExponent(N) - countTwoExponent(K) - countTwoExponent(N - K);
        bw.write(Math.min(fiveCnt, twoCnt) + "");

        bw.flush();
    }

    static long countTwoExponent(long n) {
        long two = 0;
        for (long i = 2; i <= n; i *= 2) {
            two += n / i;
        }
        return two;
    }

    static long countFiveExponent(long n) {
        long five = 0;
        for (long i = 5; i <= n; i *= 5) {
            five += n / i;
        }
        return five;
    }
}


//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        long n = Long.parseLong(st.nextToken());
//        long m = Long.parseLong(st.nextToken());
//
//        long two = 0, five = 0;
//
//        five = countFiveExponent(n) - countFiveExponent(n - m) - countFiveExponent(m);
//        two = countTwoExponent(n) - countTwoExponent(n - m) - countTwoExponent(m);
//
//        System.out.println(Math.min(two, five));
//    }
//
//    public static long countFiveExponent(long n) {
//
//        long fiveExponent = 0;
//        for (long i = 5; i <= n; i *= 5) {
//            fiveExponent += n / i;
//        }
//
//        return fiveExponent;
//    }
//
//
//    public static long countTwoExponent(long n) {
//
//        long twoExponent = 0;
//        for (long i = 2; i <= n; i *= 2) {
//            twoExponent += n / i;
//        }
//
//        return twoExponent;
//    }
