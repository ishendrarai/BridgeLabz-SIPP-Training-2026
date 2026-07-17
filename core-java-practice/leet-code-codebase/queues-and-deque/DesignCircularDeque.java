public class DesignCircularDeque {
    class MyCircularDeque {
        int[] q;
        int front, rear, len;
        
        public MyCircularDeque(int k) {
            q = new int[k];
            front = k - 1;
            rear = 0;
            len = 0;
        }
        
        public boolean insertFront(int value) {
            if (isFull()) return false;
            q[front] = value;
            front = (front - 1 + q.length) % q.length;
            len++;
            return true;
        }
        
        public boolean insertLast(int value) {
            if (isFull()) return false;
            q[rear] = value;
            rear = (rear + 1) % q.length;
            len++;
            return true;
        }
        
        public boolean deleteFront() {
            if (isEmpty()) return false;
            front = (front + 1) % q.length;
            len--;
            return true;
        }
        
        public boolean deleteLast() {
            if (isEmpty()) return false;
            rear = (rear - 1 + q.length) % q.length;
            len--;
            return true;
        }
        
        public int getFront() {
            if (isEmpty()) return -1;
            return q[(front + 1) % q.length];
        }
        
        public int getRear() {
            if (isEmpty()) return -1;
            return q[(rear - 1 + q.length) % q.length];
        }
        
        public boolean isEmpty() {
            return len == 0;
        }
        
        public boolean isFull() {
            return len == q.length;
        }
    }
}
