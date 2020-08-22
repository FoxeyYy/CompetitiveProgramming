class Solution {
    public boolean search(int[] nums, int target) {
        
        return search(nums, target, 0, nums.length - 1);
        
    }
    
    private boolean search(int[] nums, int target, int left, int right) {
        
        if (right < left) return false;
        
        int mid = left + (right - left) / 2;
                
        if (nums[mid] == target) return true;
        
        if (nums[left] < nums[mid]) { // Sorted side, regular binary search
            if (nums[left] <= target && target < nums[mid]) return search(nums, target, left, mid - 1);
            return search(nums, target, mid + 1, right);
        } else if (nums[mid] < nums[left]) {
            if (nums[mid] < target && target <= nums[right]) return search(nums, target, mid + 1, right);
            return search(nums, target, left, mid - 1);
        } else if (nums[left] == nums[mid]) {
            if (nums[mid] != nums[right]) return search(nums, target, mid + 1, right);
            
            return search(nums, target, left, mid - 1) || search(nums, target, mid + 1, right);

        }
        
        return false;
        
    }
}
