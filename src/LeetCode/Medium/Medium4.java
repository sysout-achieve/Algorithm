package LeetCode.Medium;

import java.util.Stack;

public class Medium4 {
    public static void main(String[] args) {
        System.out.println(solution("ababcdcdababcdcd"));
    }

    static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int size = s.length();
        Stack<Integer> divisor = new Stack<>();
        for (int i = 1; i <= (size / 2) + 1; i++) {
            divisor.push(i);
        }
        divisor.push(size);
        while (!divisor.isEmpty()) {
            int divideNum = divisor.pop();
            Stack<String> stringStack = new Stack<>();
            int last = 0;
            for (int i = 0; i <= size - divideNum; i += divideNum) {
                last = i + divideNum;
                stringStack.push(s.substring(i, last));
            }
            int tmpAnswer = size - last;

            String before = stringStack.pop();
            int addNum = 1;
            while (!stringStack.isEmpty()) {
                String str = stringStack.pop();
                if (str.equals(before)) {
                    addNum++;
                    continue;
                } else {
                    tmpAnswer += divideNum;
                    if (addNum != 1) tmpAnswer++;
                    before = str;
                    addNum = 1;
                }
            }
            if (addNum == 1) {
                tmpAnswer += divideNum;
            } else {
                tmpAnswer += divideNum + 1;
            }
            if (tmpAnswer != 0) answer = Math.min(tmpAnswer, answer);
        }

        return answer;
    }
}
