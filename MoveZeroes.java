class Solution {
    public void moveZeroes(int[] nums) {
        
        int zeroes = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            nums[zeroes] = nums[i];
            zeroes++;
        }
        
        Arrays.fill(nums, zeroes, nums.length, 0);
        
    }
}
