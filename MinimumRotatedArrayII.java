class Solution {
    public int findMin(int[] nums) {
                        
        int left = 0, right = nums.length - 1;
        
        return findMin(nums, left, right);
        
    }
    
    private int findMin(int[] nums, int left, int right) {
                
        if (right < left) return Integer.MAX_VALUE;
        
        int mid = left + (right - left) / 2;
        
        int min = Integer.MAX_VALUE;
                                                                
        if (nums[mid] == nums[right] && nums[mid] == nums[right]) {
            int minLeft = findMin(nums, left, mid - 1);
            int minRight = findMin(nums, mid + 1, right);
            min = Math.min(minLeft, minRight);
        } else if (nums[mid] > nums[right]) {
            min = findMin(nums, mid + 1, right);
        } else if (nums[mid] < nums[right]) {
            min = findMin(nums, left, mid - 1);
        } else {
            min = findMin(nums, mid + 1, right);
        }
        
        return Math.min(min, nums[mid]);
                                    
    }
}
