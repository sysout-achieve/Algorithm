package Programmers.Basic;

import java.util.Arrays;
import java.util.Stack;

public class Num43163 {
    public static void main(String[] args) {
        System.out.println("3".charAt(0)-'0');
    }
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;
        int cnt = 0;
        Stack<String> begins = new Stack<>();
        begins.add(begin);
        while (!begins.isEmpty()) {
            String begin2 = begins.pop();
            cnt++;
            for (String word : words) {
                int diff = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != begin2.charAt(i)) diff++;
                    if (diff > 1) break;
                }
                if (diff == 1) {
                    if (word.equals(target)) return cnt + 1;
                    else begins.add(word);
                }
            }
        }
        return 0;
    }
    private int sum(int isEven, String cardNum){
        int sum = 0;
        for(int i = cardNum.length() - 1 - isEven; i > 0; i= i - 2 + isEven){
            int temp = (cardNum.charAt(i) - '0') * (1 + isEven);
            sum += (temp/10) + (temp%10);
        }
        return sum;
    }
}
