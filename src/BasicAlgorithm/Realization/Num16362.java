package BasicAlgorithm.Realization;

import java.io.*;
import java.util.Stack;

public class Num16362 {
    public static String[] compressed;
    static StringBuilder resultStringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String patternAlpha = "^[a-zA-Z]*$"; //영어만
        String pattern = "[/%*+-]"; //기호만

        String str = br.readLine().replaceAll(" ", "");
        Stack<String> stack = new Stack<>();
        compressed = str.split("");
        int turnAlpha = 0;
        for (int i = 0; i < str.length(); i++) {
            String tmpStr = compressed[i];
            if (!tmpStr.equals(")")) {
                stack.push(tmpStr);
                if (turnAlpha == 0 && tmpStr.matches(patternAlpha)) {
                    turnAlpha = -1;
                } else if (turnAlpha == -1 && tmpStr.matches(pattern)) {
                    turnAlpha = 0;
                } else if (turnAlpha == 0 && tmpStr.equals("(")) {

                } else {
                    resultStringBuilder.append("error");
                    bw.write(resultStringBuilder.toString());
                    bw.flush();
                    bw.close();
                    return;
                }
            } else {
                int cnt = 0;
                if (stack.isEmpty()) {
                    resultStringBuilder.append("error");
                    bw.write(resultStringBuilder.toString());
                    bw.flush();
                    bw.close();
                    return;
                }
                while (!stack.pop().equals("(")) {
                    cnt++;
                    if (stack.isEmpty()) {
                        resultStringBuilder.append("error");
                        bw.write(resultStringBuilder.toString());
                        bw.flush();
                        bw.close();
                        return;
                    }
                }
                if (cnt <= 1) {
                    resultStringBuilder.append("improper");
                    bw.write(resultStringBuilder.toString());
                    bw.flush();
                    bw.close();
                    return;
                }

                stack.push("a");
            }
        }
        boolean isAble = true;

        if (stack.size() > 3) {
            while (!stack.isEmpty()) {
                String temp = stack.pop();
                if (temp.equals("(") || temp.equals(")")) isAble = false;
            }
            if (isAble) {
                resultStringBuilder.append("improper");
            } else {
                resultStringBuilder.append("error");
            }
            bw.write(resultStringBuilder.toString());
            bw.flush();
            bw.close();
            return;
        }
        while (!stack.isEmpty()) {
            String temp = stack.pop();
            if (temp.equals("(") || temp.equals(")")) isAble = false;
        }
        if (isAble) {
            resultStringBuilder.append("proper");
        } else {
            resultStringBuilder.append("error");
        }
        bw.write(resultStringBuilder.toString());
        bw.flush();
        bw.close();
    }
}