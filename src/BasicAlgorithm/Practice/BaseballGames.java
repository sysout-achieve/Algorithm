package BasicAlgorithm.Practice;

import java.util.Stack;

public class BaseballGames {
    public static void main(String[] args) {
        String[] input = {"5","-2","4","C","D","9","+","+"};
        System.out.print(solve(input)+"");
    }
    static int solve(String[] input) {
        Stack<Integer> stack = new Stack<>();
        for (String str : input){
            switch (str){
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek()*2);
                    break;
                case "+":
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y);
                    stack.push(x);
                    stack.push(x+y);
                    break;
                default:stack.push(Integer.valueOf(str));
            }
        }
        int result = 0;
        while (!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
}
