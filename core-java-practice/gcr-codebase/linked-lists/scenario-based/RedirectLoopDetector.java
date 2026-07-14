public class RedirectLoopDetector {
    static class Node {
        String url;
        Node next;
        Node(String url) { this.url = url; }
    }

    public boolean hasRedirectLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
