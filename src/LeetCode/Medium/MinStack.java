package LeetCode.Medium;

import java.util.EmptyStackException;

public class MinStack {

    static class Node<T> {
        int value;
        int min;
        Node<T> next;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    Node top;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (top != null) {
            int min = Math.min(x, top.min);
            Node t = new Node(x, min);
            t.next = top;
            top = t;
        } else {
            top = new Node(x, x);
        }
    }

    public void pop() throws EmptyStackException {
        if (top == null) throw new EmptyStackException();
        top = top.next;
    }

    public int top() {
        if (top == null) return 0;
        return top.value;
    }

    public int getMin() {
        if (top == null) return 0;

        return top.min;
    }
}


