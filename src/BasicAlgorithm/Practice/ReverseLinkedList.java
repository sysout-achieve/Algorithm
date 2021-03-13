package BasicAlgorithm.Practice;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        printNode(l1);
        ListNode head = solve(l1);
        printNode(head);
    }
    public static void printNode(ListNode head) {
        System.out.println("printNOde: ");
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode solve(ListNode input){
        ListNode prev = null;
        ListNode next = null;
        while (input != null){
            next = input.next;
            input.next = prev;
            prev = input;
            input = next;
        }
        return prev;
    }
}
