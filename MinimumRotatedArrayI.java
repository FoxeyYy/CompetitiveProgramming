class Solution {
    public int findMin(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        
        if (nums[0] <= nums[nums.length - 1]) return nums[0];
        
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            
            int mid = (left + right) / 2;
                        
            if (nums[mid] > nums[right]) {
                min = nums[right];
                left = mid + 1;
            }
            
            if (nums[mid] < nums[right]) {
                min = nums[mid];
                right = mid;
            }
                
        }
        
        return min;
        
    }
}
