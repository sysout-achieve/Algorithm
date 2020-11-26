package BasicAlgorithm.Basic;

import java.io.*;
import java.util.Stack;

public class Num1662 {
    public static String[] compressed;
    public static Stack<String> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        compressed = br.readLine().split("");
        stack = new Stack<>();

        for (int i = 0; i < compressed.length; i++) {
            String curChar = compressed[i];
            int cnt = 0;
            if (!curChar.equals(")")) {
                stack.push(curChar);
            } else {
                while (!stack.peek().equals("(")) {
                    if (stack.pop().equals("*")) {
                        cnt += Integer.parseInt(stack.pop());
                    } else {
                        ++cnt;
                    }
                }
                stack.pop();
                int k = Integer.parseInt(stack.pop()) * cnt;
                stack.push(String.valueOf(k));
                stack.push("*");
            }
        }
        int result =0;
        while (!stack.isEmpty()){
            String str = stack.pop();
            int cnt =0;
            if (str.equals("*")){
                cnt += Integer.parseInt(stack.pop());
            } else {
                cnt++;
            }
            result += cnt;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}