class RandomizedSet {
    
    private Map<Integer, Integer> valuesIndexes;
    private List<Integer> values;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valuesIndexes = new HashMap<>();
        values = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valuesIndexes.containsKey(val)) return false;
        
        values.add(val);
        valuesIndexes.put(val, values.size() - 1);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valuesIndexes.containsKey(val)) return false;
            
        //Swap last with val index, so removal is O(1)
        //P.S: We don't have to store the element to remove
        int index = valuesIndexes.get(val);
        int lastValue = values.get(values.size() - 1);
        values.set(index, lastValue);
            
        //Remove last
        values.remove(values.size() - 1);
            
        //Update indexes
        valuesIndexes.remove(val);
        if (lastValue != val) valuesIndexes.put(lastValue, index);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(values.size());
        return values.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
