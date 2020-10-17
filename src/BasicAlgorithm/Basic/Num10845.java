package BasicAlgorithm.Basic;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        Queue queue = new Queue();
        for (int i = 0; i < cnt; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; i < cnt; i++) {
            try {
                StringTokenizer token = new StringTokenizer(list.get(i));
                switch (token.nextToken()) {
                    case "push":
                        queue.push(Integer.parseInt(token.nextToken()));
                        break;
                    case "pop":
                        System.out.println(queue.pop());
                        break;
                    case "size":
                        System.out.println(queue.getSize());
                        break;
                    case "empty":
                        System.out.println(queue.empty());
                        break;
                    case "front":
                        System.out.println(queue.front());
                        break;
                    case "back":
                        System.out.println(queue.back());
                        break;
                }
            } catch (Exception e) {
                System.out.println(-1);
            }

        }

        bw.flush();
    }
}

class Queue {
    class Node {
        int value;
        Node nextNode;

        public Node(int value) {
            this.value = value;
        }
    }

    Node firstNode;
    Node lastNode;
    int size;

    public Queue() {
        size = 0;
    }

    public void push(int value) {
        Node node = new Node(value);

        if (lastNode != null) {
            lastNode.nextNode = node;
        }
        lastNode = node;
        if (firstNode == null) {
            firstNode = lastNode;
        }
        size++;
    }

    public int pop() {
        if (firstNode == null) return -1;

        int value = firstNode.value;
        firstNode = firstNode.nextNode;
        if (firstNode == null) {
            lastNode = null;
        }
        size--;
        return value;
    }

    public int getSize() {
        return size;
    }

    public int empty() {
        return firstNode == null ? 1 : 0;
    }

    public int front() {
        return firstNode == null ? -1 : firstNode.value;
    }

    public int back() {
        return lastNode.value;
    }

}
