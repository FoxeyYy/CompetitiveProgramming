class Trie {
    
    private static final int ALPHABET_SIZE = 26;
    
    private class Node {
        
        public Node[] children = new Node[Trie.ALPHABET_SIZE];
        
        public char letter;
        
        public boolean finalLetter = false;
            
        public Node(char letter) {
            this.letter = letter;
        }
        
    }
    
    private Node root = new Node('*');

    /** Initialize your data structure here. */
    public Trie() {}
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        Node current = root;
        
        for(char letter: word.toCharArray()) {
                        
            if(current.children[letter - 'a'] == null) {
                current.children[letter - 'a'] = new Node(letter);
            }
            
            current = current.children[letter - 'a'];
            
        }
        
        current.finalLetter = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        Node current = root;
        
        for(char letter: word.toCharArray()) {
            if(current.children[letter - 'a'] == null) {
                return false;
            } else {
                current = current.children[letter - 'a']; 
            }
        }
        
        return current.finalLetter;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        Node current = root;
        
        for(char letter: prefix.toCharArray()) {
            if(current.children[letter - 'a'] == null) {
                return false;
            } else {
                current = current.children[letter - 'a']; 
            }
        }
        
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
