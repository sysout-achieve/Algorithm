package BasicAlgorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 2020_1009 큐브 채우기 다시 분석 필요
public class Num1493_2 {
    static long l, w, h, n, t, in[], pow[];

    public static void main(String[] args) throws IOException {
        input();
        System.out.print(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());
        in = new long[20];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            in[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
        }
    }

    static long solve() {
        long ans = 0;
        long sum = 0;
        pow = new long[20];
        pow[0] = 1;
        for (int i = 1; i < 20; i++) {
            pow[i] = pow[i - 1] * 2;
        }
        for (int i = 19; i >= 0; i--) {
            sum *= 8;
            t = Math.min(in[i], (l / pow[i]) * (w / pow[i]) * (h / pow[i]) - sum);
            sum += t;
            ans += t;
        }
        return sum == l * w * h ? ans : -1;
    }
}



