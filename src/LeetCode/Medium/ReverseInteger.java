package LeetCode.Medium;

import java.util.Stack;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        String str = String.valueOf(x);
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int result = 0;
        if (str.charAt(0) == '-') {
            sb.append("-");
        } else {
            stack.push(str.charAt(0));
        }
        for (int i = 1; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        long value = Long.parseLong(sb.toString());
        if (Integer.MAX_VALUE >= value && Integer.MIN_VALUE <= value){
            result = (int)value;
        }
        return result;
    }

//    public static int reverse(int x) {
//        int rev = 0;
//        while (x != 0) {
//            int pop = x % 10;
//            x /= 10;
//            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
//            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
//            rev = rev * 10 + pop;
//        }
//        return rev;
//    }
}
