package BasicAlgorithm.Basic;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DequeData dequeData = new DequeData();

        int cnt = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            list.add(br.readLine());
        }
        StringTokenizer st;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(list.get(i));
            switch (st.nextToken()) {
                case "push_front":
                    dequeData.pushFront(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dequeData.pushBack(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    System.out.println(dequeData.popFront());
                    break;
                case "pop_back":
                    System.out.println(dequeData.popBack());
                    break;
                case "size":
                    System.out.println(dequeData.size());
                    break;
                case "empty":
                    System.out.println(dequeData.empty());
                    break;
                case "front":
                    System.out.println(dequeData.front());
                    break;
                case "back":
                    System.out.println(dequeData.back());
                    break;
            }
        }
    }
}

class DequeData {
    class Node {
        int value;
        Node nextNode;
        Node beforeNode;

        public Node(int value) {
            this.value = value;
        }
    }

    Node first;
    Node last;

    int size;

    public DequeData() {
        size = 0;
    }

    public void pushFront(int data) {
        size++;
        Node now = new Node(data);

        if (last == null) {
            last = now;
        }

        if (first == null) {
            first = now;
            return;
        }
        Node nextNode = first;
        first.beforeNode = now;
        first = now;
        first.nextNode = nextNode;
    }

    public void pushBack(int data) {
        size++;
        Node now = new Node(data);

        if (last != null) {
            last.nextNode = now;
            now.beforeNode = last;
        }
        last = now;
        if (first == null) {
            first = last;
        }
    }

    public int popFront() {
        if (first == null) return -1;
        size--;
        int result = first.value;
        if (first.nextNode == null || size==0) {
            first = null;
            last = null;
        } else {
            first = first.nextNode;
        }
        return result;
    }

    public int popBack() {
        if (last == null) return -1;
        size--;
        int result = last.value;
        if (last.beforeNode == null || size ==0) {
            first = null;
            last = null;
        } else {
            last = last.beforeNode;
        }
        return result;
    }

    public int front() {
        if (first == null) return -1;
        return first.value;
    }

    public int back() {
        if (last == null) return -1;
        return last.value;
    }

    public int size() {
        return size;
    }

    public int empty() {
        return size == 0 ? 1 : 0;

    }
}