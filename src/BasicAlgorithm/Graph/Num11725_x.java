package BasicAlgorithm.Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num11725_x {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int lineCnt = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] array = new ArrayList[lineCnt + 1];
        int[] allSize = new int[lineCnt + 1];
        for (int i = 0; i <= lineCnt; i++) {
            array[i] = new ArrayList<>();
        }
        for (int i = 0; i < lineCnt - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            array[x].add(y);
            array[y].add(x);
            allSize[x]++;
            allSize[y]++;
        }
        TreeA.Node node = new TreeA.Node(1);
        TreeA treeA = new TreeA(node, array, allSize);
        for (int i = 2; i <= lineCnt; i++) {
            treeA.getParent(treeA.root, i, allSize);
        }
        bw.flush();
    }
}

class TreeA {
    Node root;

    public TreeA(Node root, ArrayList<Integer>[] arrayLists, int[] allsize) {
        this.root = root;
        child(root, arrayLists, allsize, root.value);
    }

    static class Node {
        int value;

        ArrayList<Node> child;

        public Node(int value) {
            this.value = value;
            child = new ArrayList<>();
        }

        public Node addChild(Node node) {
            child.add(node);
            return node;
        }
    }

    public void child(Node node, ArrayList<Integer>[] arrayLists, int[] allSize, int parent) {
        for (int i = allSize[node.value] - 1; i >= 0; i--) {
            int childNum = arrayLists[node.value].get(i);
            if (childNum == parent) {
                arrayLists[node.value].remove(i);
                allSize[node.value]--;
            }
        }
        for (int i = allSize[node.value] - 1; i >= 0; i--) {
            int childNum = arrayLists[node.value].get(i);
            child(node.addChild(new Node(childNum)), arrayLists, allSize, node.value);
        }
    }

    public void getParent(Node node, int num, int[] allSize) {
        if (node == null) return;
        for (int i = 0; i < allSize[node.value]; i++) {
            Node tmpNode = node.child.get(i);
            if (tmpNode.value == num) {
                System.out.print(node.value + "\n");
                return;
            }
            getParent(tmpNode, num, allSize);
        }
    }
}