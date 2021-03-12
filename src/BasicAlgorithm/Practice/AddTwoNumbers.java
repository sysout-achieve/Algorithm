package BasicAlgorithm.Practice;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);
        ListNode node = solve(l1, l2);
        while(node!=null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
    static ListNode solve(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode c1 = l1, c2 = l2, p = result;
        int carry = 0;
        while (c1 != null || c2 != null){
            if (c1 != null){
                carry += c1.val;
                c1 = c1.next;
            }
            if (c2 != null){
                carry += c2.val;
                c2 = c2.next;
            }
            p.next = new ListNode(carry%10);
            p = p.next;
            carry /= 10;
        }
        if (carry != 0){
            p.next = new ListNode(carry);
        }
        return result.next;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}