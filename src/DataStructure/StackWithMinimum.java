package DataStructure;

import java.util.Stack;

public class StackWithMinimum {
    public static void main(String[] args) {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(3);
        stackWithMin.push(5);
        stackWithMin.push(1);
        stackWithMin.push(2);

        System.out.println("pop: "+stackWithMin.pop().value);
        System.out.println("min: "+stackWithMin.min());
        System.out.println("pop: "+stackWithMin.pop().value);
        System.out.println("min: "+stackWithMin.min());
    }
}

class NodeWithMin{
    int min;
    int value;

    public NodeWithMin(int min, int value) {
        this.min = min;
        this.value = value;
    }
}


class StackWithMin extends Stack<NodeWithMin> {
    public int min(){
        if (this.isEmpty()){
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }

    public void push(int value){
        int minValue = Math.min(min(), value);
        super.push(new NodeWithMin(minValue, value));
    }

}