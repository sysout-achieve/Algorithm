package DataStructure;

import java.util.EmptyStackException;
import java.util.Stack;

class FullStackException extends Exception {
    public FullStackException() {
        super();
    }

    public FullStackException(String msg) {
        super(msg);
    }
}

class MultiStacks {
    private int[] values;
    private StackInfo[] info;

    class StackInfo {
        public int start, dataSize, stackSize;

        public StackInfo(int start, int stackSize) {
            this.start = start;
            this.stackSize = stackSize;
            this.dataSize = 0;
        }

        public boolean isWithinIndex(int index) {
            if (index < 0 || index >= values.length) {
                return false;
            }
            int virtualIndex = index < start ? index + values.length : index;
            int end = start + stackSize;
            return start <= virtualIndex && virtualIndex < end;
        }

        public int getLastStackIndex() {
            return adjustIndex(start + stackSize - 1);
        }

        public int getLastDataIndex() {
            return adjustIndex(start + dataSize - 1);
        }

        public int getNewDataIndex() {
            return adjustIndex(getLastDataIndex() + 1);
        }

        public boolean isFull() {
            return dataSize == stackSize;
        }

        public boolean isEmpty() {
            return dataSize == 0;
        }
    }

    public MultiStacks(int numOfStack, int defaultSize) {
        info = new StackInfo[numOfStack];
        for (int i = 0; i < numOfStack; i++) {
            info[i] = new StackInfo(defaultSize * i, defaultSize);
        }
        values = new int[numOfStack * defaultSize];
    }

    private void expand(int stackNum) {
        int nextStack = (stackNum + 1) % info.length;
        shift(nextStack);
        info[stackNum].stackSize++;
    }

    private void shift(int stackNum) {
        StackInfo stack = info[stackNum];
        if (stack.dataSize >= stack.stackSize) {
            int nextStack = (stackNum + 1) & info.length;
            shift(nextStack);
            stack.stackSize++;
//            expand(stackNum);
        }
        int index = stack.getLastStackIndex();
        while (stack.isWithinIndex(index)) {
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);

        }
        values[stack.start] = 0;
        stack.start = nextIndex(stack.start);
        stack.stackSize--;
    }

    private int adjustIndex(int index) {
        int max = values.length;
        return ((index % max) + max) % max;
    }

    private int nextIndex(int index) {
        return adjustIndex(index + 1);
    }

    private int previousIndex(int index) {
        return adjustIndex(index - 1);
    }

    public int numberOfElements() {
        int totalDataSize = 0;
        for (StackInfo stackInfo : info) {
            totalDataSize += stackInfo.dataSize;
        }
        return totalDataSize;
    }

    public boolean allStackAreFull() {
        return numberOfElements() == values.length;
    }

    public void push(int stackNum, int value) throws FullStackException {
        if (allStackAreFull()) throw new FullStackException();
        StackInfo stackInfo = info[stackNum];
        if (stackInfo.isFull()) expand(stackNum);
        values[stackInfo.getNewDataIndex()] = value;
        stackInfo.dataSize++;
    }

    public int pop(int stackNum) throws EmptyStackException {
        StackInfo stackInfo = info[stackNum];
        if (stackInfo.isEmpty()) throw new EmptyStackException();
        int result = values[stackInfo.getLastDataIndex()];
        values[stackInfo.getLastDataIndex()] = 0;
        stackInfo.dataSize--;
        return result;
    }

    public int peek(int stackNum) throws EmptyStackException {
        StackInfo stackInfo = info[stackNum];
        if (stackInfo.isEmpty()) throw new EmptyStackException();
        return values[stackInfo.getLastDataIndex()];
    }

}

public class ArrayMultiStack {
    public static void main(String[] args) {
//        System.out.println("hello");
        MultiStacks ms = new MultiStacks(3, 5);
//        System.out.println("It's Full");

        try {
            ms.push(0, 1);
            ms.push(0, 2);
            ms.push(0, 3);
            ms.push(0, 4);
            ms.push(0, 5);
            ms.push(0, 6);
            ms.push(0, 7);
            ms.push(0, 8);
            ms.push(0, 9);


            ms.push(1, 11);
            ms.push(1, 12);
            ms.push(1, 13);
            ms.push(1, 14);
            ms.push(1, 15);
        } catch (FullStackException e) {
            // TODO Auto-generated catch block
            System.out.println("It's Full");
        }


        try {
            System.out.println(ms.pop(0));
            System.out.println(ms.pop(0));
            System.out.println(ms.pop(0));
            System.out.println(ms.pop(0));
            System.out.println(ms.pop(0));
            System.out.println(ms.pop(0));
            System.out.println(ms.pop(0));
            System.out.println(ms.pop(0));
            System.out.println(ms.pop(0));

            System.out.println(ms.pop(1));
            System.out.println(ms.pop(1));
            System.out.println(ms.pop(1));
            System.out.println(ms.pop(1));
            System.out.println(ms.pop(1));

        } catch (EmptyStackException e) {
            System.out.println("It's Empty");
        }

    }
}
