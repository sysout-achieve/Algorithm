package LeetCode.Medium;

import java.util.Stack;

public class Medium4 {
    public static void main(String[] args) {
        System.out.println(solution("ccc"));
    }

    static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int size = s.length();
        Stack<Integer> divisor = new Stack<>();
        for (int i = 1; i <= size; i++) {
            if ((size % i) == 0) divisor.push(i);
        }
        while (!divisor.isEmpty()) {
            int divideNum = divisor.pop();
            Stack<String> stringStack = new Stack<>();
            for (int i = 0; i <= size - divideNum; i += divideNum) {
                stringStack.push(s.substring(i, i + divideNum));
            }
            String before = stringStack.pop();
            int addNum = 0;
            int tmpAnswer = before.length();
            while (!stringStack.isEmpty()) {
                String str = stringStack.pop();
                if (str.equals(before)) {
                    addNum++;
                    continue;
                } else {
                    if (addNum == 0) tmpAnswer += divideNum;
                    else tmpAnswer++;
                    before = str;
                    addNum = 0;
                }
            }
            if (addNum != 0) {
                tmpAnswer += divideNum+1;
            }
            answer = Math.min(tmpAnswer, answer);
        }

        return answer;
    }
}
