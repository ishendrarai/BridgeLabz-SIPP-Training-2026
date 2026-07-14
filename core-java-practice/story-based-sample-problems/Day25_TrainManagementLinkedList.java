public class Day25_TrainManagementLinkedList {
    static class Node {
        int id;
        Node next;
        public Node(int id) { this.id = id; }
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        
        System.out.println("Original Train:");
        printList(head);
        
        System.out.println("Reversed Train:");
        head = reverseList(head);
        printList(head);
        
        System.out.println("Middle Coach:");
        System.out.println(findMiddle(head).id);
        
        System.out.println("Detect Cycle (should be false): " + hasCycle(head));
    }
    
    static Node reverseList(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    
    static Node findMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    static boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
    
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.id + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
