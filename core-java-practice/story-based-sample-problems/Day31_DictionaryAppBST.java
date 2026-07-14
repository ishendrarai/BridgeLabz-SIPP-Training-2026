public class Day31_DictionaryAppBST {
    static class Node {
        String word;
        Node left, right;
        public Node(String w) { word = w; }
    }
    
    private Node root;
    
    public void insert(String w) {
        root = insertRec(root, w);
    }
    private Node insertRec(Node root, String w) {
        if (root == null) return new Node(w);
        if (w.compareTo(root.word) < 0) root.left = insertRec(root.left, w);
        else if (w.compareTo(root.word) > 0) root.right = insertRec(root.right, w);
        return root;
    }
    
    public void delete(String w) {
        root = deleteRec(root, w);
    }
    private Node deleteRec(Node root, String w) {
        if (root == null) return root;
        if (w.compareTo(root.word) < 0) root.left = deleteRec(root.left, w);
        else if (w.compareTo(root.word) > 0) root.right = deleteRec(root.right, w);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.word = minValue(root.right);
            root.right = deleteRec(root.right, root.word);
        }
        return root;
    }
    private String minValue(Node root) {
        String minv = root.word;
        while (root.left != null) {
            minv = root.left.word;
            root = root.left;
        }
        return minv;
    }
    
    public boolean search(String w) {
        return searchRec(root, w) != null;
    }
    private Node searchRec(Node root, String w) {
        if (root == null || root.word.equals(w)) return root;
        if (root.word.compareTo(w) > 0) return searchRec(root.left, w);
        return searchRec(root.right, w);
    }
    
    public String kthSmallest(int k) {
        int[] count = new int[]{0};
        String[] result = new String[]{""};
        kthSmallestRec(root, k, count, result);
        return result[0];
    }
    private void kthSmallestRec(Node root, int k, int[] count, String[] result) {
        if (root == null || count[0] >= k) return;
        kthSmallestRec(root.left, k, count, result);
        count[0]++;
        if (count[0] == k) {
            result[0] = root.word;
            return;
        }
        kthSmallestRec(root.right, k, count, result);
    }
    
    public Node lca(String w1, String w2) {
        return lcaRec(root, w1, w2);
    }
    private Node lcaRec(Node root, String w1, String w2) {
        if (root == null) return null;
        if (root.word.compareTo(w1) > 0 && root.word.compareTo(w2) > 0)
            return lcaRec(root.left, w1, w2);
        if (root.word.compareTo(w1) < 0 && root.word.compareTo(w2) < 0)
            return lcaRec(root.right, w1, w2);
        return root;
    }
    
    public static void main(String[] args) {
        Day31_DictionaryAppBST dict = new Day31_DictionaryAppBST();
        String[] words = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape"};
        for (String w : words) dict.insert(w);
        
        System.out.println("Search 'cherry': " + dict.search("cherry"));
        System.out.println("3rd alphabetically: " + dict.kthSmallest(3));
        
        Node lcaNode = dict.lca("banana", "date");
        System.out.println("LCA of banana and date: " + (lcaNode != null ? lcaNode.word : "null"));
        
        dict.delete("cherry"); // Delete node with no/one/two children tested conceptually
        System.out.println("Search 'cherry' after delete: " + dict.search("cherry"));
    }
}
