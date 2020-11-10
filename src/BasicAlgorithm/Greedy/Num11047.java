package BasicAlgorithm.Greedy;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            stack.push(Integer.parseInt(st.nextToken()));
        }
        int result = 0;
        while (!stack.isEmpty()) {
            int coin = stack.pop();
            result += value / coin;
            value = value % coin;
            if (value == 0) break;
        }
        bw.write(result + "");
        bw.flush();
    }
}