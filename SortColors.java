class Solution {
    public void sortColors(int[] nums) {
        
        int left = 0, right = nums.length - 1, current = 0;
                
        while(current <= right) {
            if(nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            } else if(nums[current] == 1) {
                current++;
            } else {
                swap(nums, current, right);
                right--;
            }
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
