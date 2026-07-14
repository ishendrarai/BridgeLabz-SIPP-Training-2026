public class ImplementTrie {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) return false;
            current = current.children[index];
        }
        return current.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) return false;
            current = current.children[index];
        }
        return true;
    }
}
