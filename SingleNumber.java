class Solution {
    public int singleNumber(int[] nums) {
        
        int sol = 0;
        
        for (Integer num: nums) {
            sol ^= num;
        }
        
        return sol;
        
    }
}
