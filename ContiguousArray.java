class Solution {
    public int findMaxLength(int[] nums) {
        
        Map<Integer, Integer> indexes = new HashMap<>();
        indexes.put(0, -1);
        
        int maxlen = 0, count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            count = count + (nums[i] == 1 ? 1 : -1);
            
            if (indexes.containsKey(count)) {
                maxlen = Math.max(maxlen, i - indexes.get(count));
            } else {
                indexes.put(count, i);
            }
        }
        
        return maxlen;
    }
}
