class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }
    
    public List<List<Integer>> subsets(int[] nums, int currentIdx) {
        
        //Nothing left, empty set
        if (currentIdx == nums.length) {
            List<Integer> emptySet = new ArrayList<>();
            List<List<Integer>> emptyList = new ArrayList<List<Integer>>();
            emptyList.add(emptySet);
            return emptyList;
        }
         
        //Generate next number subsets
        List<List<Integer>> nextIdxSubsets = subsets(nums, currentIdx + 1);
        
        //Copy them
        List<List<Integer>> newSubsets = new LinkedList<List<Integer>>();
        
        // Prepend current number & a clone of the subset
        for(List<Integer> subset: nextIdxSubsets) {
            
            List<Integer> newSubset = new LinkedList<>(subset);
            newSubset.add(nums[currentIdx]);
            
            newSubsets.add(subset);
            newSubsets.add(newSubset);

        }
            
        return newSubsets;
        
    }
}
