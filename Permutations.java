class Solution {
    
    // Space: O(n!)
    // Time complexity: O(n^2*n!)
    public List<List<Integer>> permute(int[] nums) {
        
        if (nums.length == 0) {
            List<Integer> perm = new LinkedList<Integer>();
            List<List<Integer>> perms = new LinkedList<List<Integer>>();
                                        
            perms.add(perm);
            
            return perms;
        }
        
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);
                
        List<List<Integer>> prevPermutations = permute(nums2);
        List<List<Integer>> permutations = new LinkedList<List<Integer>>();
        
        for(List<Integer> permutation: prevPermutations) {
            for (int i = 0;  i <= permutation.size(); i++) {
                List<Integer> newPerm = new LinkedList<>(permutation);
                newPerm.add(i, nums[0]);
                permutations.add(newPerm); 
            }
        }
        
        return permutations;
    }
    
}
