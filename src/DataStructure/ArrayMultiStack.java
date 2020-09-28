package DataStructure;

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
        }
        int index = stack.getLastStackIndex();
        while (stack.isWithinIndex(index)) {
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);
        }
        values[stack.start] = nextIndex(stack.start);
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
        return adjustIndex(index);
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

}

public class ArrayMultiStack {
    public static void main(String[] args) {

    }
}
