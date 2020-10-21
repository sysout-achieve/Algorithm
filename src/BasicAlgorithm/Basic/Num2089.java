package BasicAlgorithm.Basic;

import java.io.*;
import java.util.Stack;

public class Num2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int input = Integer.parseInt(br.readLine());
        if (input == 0) {
            bw.write("0");
        }
        while (input != 0) {
            stack.push(Math.abs(input % (-2)));
            input = (int) Math.ceil((double) input / -2);
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + "");
        }

        bw.flush();
    }
}