package Programmers.Basic;

import java.util.Arrays;
import java.util.Stack;

public class Num43163 {
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
                    if (word.equals(target)) return cnt;
                    else begins.add(word);
                }
            }
        }
        return 0;
    }

}
