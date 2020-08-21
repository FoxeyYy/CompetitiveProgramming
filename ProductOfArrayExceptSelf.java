class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] sol = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            sol[i] = i == 0 ? 1 : nums[i-1] * sol[i-1];
        }
        
        int R = 1;
        for(int i = nums.length - 1; i > -1; i--) {
            sol[i] *= R;
            R *= nums[i];
        }
        
        return sol;
        
    }
}
