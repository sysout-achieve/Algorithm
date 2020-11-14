package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Stack;

public class Leet1 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = (l1.val + l2.val);
        int add = tmp / 10;
        String tempValue = String.valueOf(tmp % 10);
        while (l1.next != null || l2.next != null) {
            if (l1.next == null) {
                l1.next = new ListNode(0);
            }
            if (l2.next == null) {
                l2.next = new ListNode(0);
            }
            tmp = l1.next.val + l2.next.val + add;
            add = tmp / 10;
            tempValue += String.valueOf(tmp % 10);
            l1 = l1.next;
            l2 = l2.next;
        }
        if (add == 1) {
            tempValue += "1";
        }
        ListNode listNode = new ListNode(tempValue.charAt(0)-'0');
        ListNode tmpNode = listNode;
        for (int i = 1; i < tempValue.length(); i++) {
            tmpNode.next = new ListNode(tempValue.charAt(i)-'0');
            tmpNode = tmpNode.next;
        }

        return listNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
