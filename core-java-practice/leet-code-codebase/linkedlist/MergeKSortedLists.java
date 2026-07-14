import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;
            if (minNode.next != null) pq.add(minNode.next);
        }
        return dummy.next;
    }
}
