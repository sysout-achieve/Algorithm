package DataStructure;

import java.util.Stack;

public class StackWithMinimum2 {

    public static void main(String[] args) {
        ValueStack valueStack = new ValueStack();
        valueStack.push(3);
        valueStack.push(1);
        valueStack.push(5);
        valueStack.push(1);
        valueStack.push(2);

        System.out.println(""+valueStack.pop());
        System.out.println("min"+valueStack.min());
        System.out.println(""+valueStack.pop());
        System.out.println("min"+valueStack.min());
        System.out.println(""+valueStack.pop());
        System.out.println("min"+valueStack.min());
        System.out.println(""+valueStack.pop());
        System.out.println("min"+valueStack.min());
        System.out.println(""+valueStack.pop());
    }

}


class ValueStack extends Stack<Integer>{

    Stack<Integer> minStack;

    public ValueStack() {
        this.minStack = new Stack<>();
    }

    public int min(){
        if (minStack.isEmpty()) return Integer.MAX_VALUE;
        else return minStack.peek();
    }

    public void push(int item) {
        super.push(item);
        if (item <= min()) minStack.push(item);
    }

    public Integer pop(){
        int value = super.pop();
        if (value == min()) minStack.pop();
        return value;
    }

}
