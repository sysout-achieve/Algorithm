package LeetCode.Medium;

public class TestMinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        StringBuilder sb = new StringBuilder();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        sb.append(minStack.getMin()+"\n");
        minStack.pop();
        sb.append(minStack.top()+"\n");
        sb.append(minStack.getMin());
        System.out.println(sb.toString());

    }
}
