class Solution {

    //Time: O(n) where n is nums length
    //Space: O(1)
    public boolean canJump(int[] nums) {
        
        
        int lastGoodPos = nums.length - 1;
        
        for(int i = nums.length - 2; i >= 0; i--) {
            
            if (i + nums[i] >= lastGoodPos) lastGoodPos = i;
            
        }
        
        return lastGoodPos == 0;
        
    }
    
}
