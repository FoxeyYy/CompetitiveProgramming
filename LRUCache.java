class LRUCache {
    
    private class Node {
        Integer val;
        Integer key;
        Node prev;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
        
        public String toString() {
            return key + " -> " + val;
        }
        
    }
    
    private int capacity;
    private Map<Integer, Node> cache;
    private Node listHead, listLast;

    public LRUCache(int capacity) {
        assert capacity >= 0 : "capacity is negative";
        
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.listHead = null; 
        this.listLast = null; 
        
    }
    
    /**
    Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    */
    public int get(int key) {
        assert key >= 0 : "key is negative";
        
        if (!cache.containsKey(key)) return -1;
        
        Node node = cache.get(key);
        
        put(node.key, node.val);
                                        
        return node.val;
    }
    
    
    /**
    Set or insert the value if the key is not already present. 
    When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
    */
    public void put(int key, int value) {
        assert key >= 0 : "key is negative";
        
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;

            removeNode(node);
            addFirst(node);
            
            return;
        
        }
        
        if (cache.size() == capacity) {
            cache.remove(listLast.key);
            removeNode(listLast);
        }
        
        
        Node node = new Node(key, value);
                
        addFirst(node);
        cache.put(key, node);
                        
    }
    
    private void addFirst(Node node) {
        
        if (listHead != null) listHead.prev = node;
        node.next = listHead;
        node.prev = null;
        listHead = node;
        
        if (listLast == null) listLast = listHead;
        
    }
    
    private void removeNode(Node node) {
                
        if (node.prev == null) listHead = node.next;
        else node.prev.next = node.next;
        
        if (node.next == null) listLast = node.prev;
        else node.next.prev = node.prev;
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
