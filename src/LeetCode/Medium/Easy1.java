package LeetCode.Medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class Easy1 {
    public long solution(long n) {
        long answer = 0;
        String valueStr = String.valueOf(n);
        Vector<Integer> vector = new Vector<>();
        int size = valueStr.length();
        for (int i = 0; i < size; i++) {
            vector.add(valueStr.charAt(i) - '0');
        }
        Collections.sort(vector, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < size; i++) {
            answer = answer * 10 + vector.get(i);
        }
        return answer;
    }
}
