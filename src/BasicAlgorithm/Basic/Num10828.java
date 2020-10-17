package BasicAlgorithm.Basic;

import java.io.*;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.StringTokenizer;

public class Num10828 {
    static NodeStack nodeStack = new NodeStack();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        ArrayList<StringTokenizer> stList = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            stList.add(new StringTokenizer(br.readLine()));
        }
        for (int i = 0; i < cnt; i++) {
            solve(stList.get(i));
        }
    }

    static void solve(StringTokenizer st) {
        String cmd = st.nextToken();
        if (cmd.equals("push")) {
            nodeStack.push(Integer.parseInt(st.nextToken()));
        } else if (cmd.equals("pop")) {
            try {
                System.out.println(nodeStack.pop());
            } catch (EmptyStackException e) {
                System.out.println(-1);
            }
        } else if (cmd.equals("size")) {
            System.out.println(nodeStack.size());
        } else if (cmd.equals("top")) {
            try {
                System.out.println(nodeStack.top());
            } catch (EmptyStackException e) {
                System.out.println(-1);
            }
        } else if (cmd.equals("empty")) {
            System.out.println(nodeStack.isEmpty());
        }
    }

}

class NodeStack {
    class Node {
        Integer value;
        Node nextNode;

        public Node(Integer value) {
            this.value = value;
        }
    }

    int size;
    Node node;

    public NodeStack() {
        this.size = 0;
    }

    public Integer pop() throws EmptyStackException {
        if (node == null) throw new EmptyStackException();
        Integer result = node.value;
        node = node.nextNode;
        size--;
        return result;
    }

    public void push(Integer data) {
        Node nextNode = node;
        node = new Node(data);
        node.nextNode = nextNode;
        size++;
    }

    public Integer top() {
        if (node == null) throw new EmptyStackException();
        return node.value;
    }

    public int isEmpty() {
        if (node == null) return 1;
        return 0;
    }

    public int size() {
        return size;
    }

}
