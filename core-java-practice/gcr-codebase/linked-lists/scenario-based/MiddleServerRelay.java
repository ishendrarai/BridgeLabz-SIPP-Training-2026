public class MiddleServerRelay {
    static class Node {
        String serverId;
        Node next;
        Node(String id) { this.serverId = id; }
    }

    public Node findMiddleServer(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
