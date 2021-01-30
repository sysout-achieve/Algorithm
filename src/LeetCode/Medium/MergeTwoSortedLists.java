package LeetCode.Medium;

public class MergeTwoSortedLists {

    //1번 풀이
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode tempNode = result;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tempNode.next = l2;
                l2 = l2.next;
            } else {
                tempNode.next = l1;
                l1 = l1.next;
            }
            tempNode = tempNode.next;
        }
        if (l1 != null) tempNode.next = l1;
        if (l2 != null) tempNode.next = l2;
        return result.next;
    }

    //2번 풀이
    public static ListNode mergeTwoListsWithRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
