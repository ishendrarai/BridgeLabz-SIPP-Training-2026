public class PlaylistQueue {
    static class Node {
        int trackId;
        Node next;
        Node(int trackId) { this.trackId = trackId; }
    }

    public void insertAfter(Node current, int trackId) {
        Node newNode = new Node(trackId);
        newNode.next = current.next; 
        current.next = newNode;
    }
}
