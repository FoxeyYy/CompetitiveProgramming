class RecentCounter {
    
    List<Integer> pings;

    public RecentCounter() {
        pings = new LinkedList<>();
    }
    
    //Time: O(1), since we always have up to 3000 elements.
    //Space: O(1), same reason
    public int ping(int t) {
        pings.add(t);
        
        clearPings(t);
        
        return pings.size();
    }
    
    private void clearPings(int t) {
        
        while(!pings.isEmpty() && pings.get(0) < t - 3000) {
            pings.remove(0);
        }
        
    }
    
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
