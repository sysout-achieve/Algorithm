package BasicAlgorithm.Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(solve(root));
    }

    static List<List<Integer>> solve(TreeNode tree) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(tree);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = q.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    q.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    q.offer(treeNode.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}
