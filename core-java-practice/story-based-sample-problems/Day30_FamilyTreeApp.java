import java.util.*;

public class Day30_FamilyTreeApp {
    static class Node {
        String name;
        Node left, right;
        public Node(String n) { name = n; }
    }
    
    public static void main(String[] args) {
        Node root = new Node("Grandpa");
        root.left = new Node("Dad");
        root.right = new Node("Uncle");
        root.left.left = new Node("Me");
        root.left.right = new Node("Brother");
        
        System.out.println("--- Iterative Level Order BFS ---");
        levelOrder(root);
        
        System.out.println("Height: " + height(root));
        System.out.println("Balanced? " + isBalanced(root));
    }
    
    public static void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            System.out.print("Level " + level + " (" + size + " nodes): ");
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                System.out.print(curr.name + " ");
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            System.out.println();
            level++;
        }
    }
    
    public static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
    public static boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }
    
    private static int checkHeight(Node root) {
        if (root == null) return 0;
        int leftH = checkHeight(root.left);
        if (leftH == -1) return -1;
        int rightH = checkHeight(root.right);
        if (rightH == -1) return -1;
        if (Math.abs(leftH - rightH) > 1) return -1;
        return 1 + Math.max(leftH, rightH);
    }
}
