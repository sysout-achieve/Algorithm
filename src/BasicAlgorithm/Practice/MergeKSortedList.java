package BasicAlgorithm.Practice;

import java.util.PriorityQueue;

public class MergeKSortedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;
        ListNode result = solve(list);
        while (result != null){
            System.out.print( result.val+" ");
            result = result.next;
        }
    }
    //대안 1. priorityQueue 에 전체 넣고 ListNode에 담아 return

    public static ListNode solve(ListNode[] input){
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b)-> a.val - b.val);
        ListNode result = new ListNode(0);
        ListNode p = result;

        for (ListNode node :input){
            q.offer(node);
        }
        while (!q.isEmpty()){
            ListNode node = q.poll();
            p.next = node;
            p = p.next;
            if (node.next!=null){
                q.offer(node.next);
            }
        }

        return result.next;
    }
}
