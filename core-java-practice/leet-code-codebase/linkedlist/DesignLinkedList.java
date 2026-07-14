public class DesignLinkedList {
    class Node {
        int val;
        Node next;
        Node prev;
        Node(int val) { this.val = val; }
    }

    int size;
    Node head, tail;

    public DesignLinkedList() {
        size = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node curr = head;
        for (int i = 0; i <= index; i++) curr = curr.next;
        return curr.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        
        Node pred = head;
        for (int i = 0; i < index; i++) pred = pred.next;
        Node succ = pred.next;
        
        Node toAdd = new Node(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        
        Node pred = head;
        for (int i = 0; i < index; i++) pred = pred.next;
        Node succ = pred.next.next;
        
        pred.next = succ;
        succ.prev = pred;
        size--;
    }
}
