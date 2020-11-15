package LeetCode.Medium;

public class Easy2 {
    public boolean solution(int x) {
        String valueStr = String.valueOf(x);
        int size = valueStr.length();
        int divideVal = 0;
        for (int i = 0; i < size; i++) {
            divideVal += valueStr.charAt(i) - '0';
        }

        return x % divideVal == 0;
    }
}
