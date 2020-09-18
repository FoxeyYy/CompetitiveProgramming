class Solution {
    
    //Space complexity: O(1)
    //Time complexity: O(logn) where n is nums size
    public int[] searchRange(int[] nums, int target) {
        
        int left = 0, right = nums.length - 1;        
        int leftMost = -1, rightMost = -1;
        
        //Search min
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            if (nums[mid] == target) {
                leftMost = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        
        left = Math.max(0,  leftMost);
        right = nums.length - 1;
        
        //Search right
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            if (nums[mid] == target) {
                rightMost = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        
        return new int[]{leftMost, rightMost};
        
    }
}
