package BasicAlgorithm.Basic;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];
        st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = cnt - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0; //10진수값
        for (int i = 0; i < cnt; i++) {
            result += arr[i] * Math.pow(a, i);
        }

        while (result != 0) {
            stack.push(result % b);
            result /= b;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop() +" ");
        }
        bw.write(sb.toString());

        bw.flush();
    }
}