package BasicAlgorithm.Basic;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int cnt = Integer.parseInt(br.readLine());

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c : input.toCharArray()) {
            stack1.push(c);
        }
        StringTokenizer stringTokenizer;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            switch (stringTokenizer.nextToken()) {
                case "L":
                    if (!stack1.isEmpty()) stack2.push(stack1.pop());
                    break;
                case "D":
                    if (!stack2.isEmpty()) stack1.push(stack2.pop());
                    break;
                case "B":
                    if (!stack1.isEmpty()) stack1.pop();
                    break;
                case "P":
                    stack1.push(stringTokenizer.nextToken().charAt(0));
                    break;
            }
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        while (!stack2.isEmpty()) {
            sb.append(stack2.pop());
        }

        bw.write(sb.toString());
        bw.flush();
    }
}