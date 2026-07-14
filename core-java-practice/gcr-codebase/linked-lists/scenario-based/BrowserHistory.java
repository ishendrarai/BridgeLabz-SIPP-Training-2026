public class BrowserHistory {
    static class Node {
        String url;
        Node next;
        Node(String url) { this.url = url; }
    }

    public Node reverseHistory(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
