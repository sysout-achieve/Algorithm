package BasicAlgorithm.Practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
//        String str= "()[]{}"  ;//true;
//        String str= "(}"  ;//false;
        String str = "([}}])";
        System.out.print(solve(str)+"");
    }
    static boolean solve(String input){
        char[] arr = input.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        Stack<Character> stack = new Stack<>();
        for (char c : arr){
            switch (c){
                case ']':
                case '}':
                case ')':
                    if (map.get(c) == stack.pop()) continue;
                    else return false;
                default: stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
