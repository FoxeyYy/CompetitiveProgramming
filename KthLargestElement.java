class Solution {

    //Time: O(nums.length) average, O(nums.length^2) worst case.
    //Space: O(log(nums.length)) due to recursive approach
    public int findKthLargest(int[] nums, int k) {
        
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
        
    }
    
    private int quickSelect(int[] nums, int k, int left, int right) {
        
        if (left > right) return -1;
        
        int pivotIdx = partition(nums, left, right);
        
        if (pivotIdx == k) return nums[k];
        if (pivotIdx < k) return quickSelect(nums, k, pivotIdx + 1, right);
        else return quickSelect(nums, k, left, pivotIdx - 1);
        
    }
    
    private int partition(int[] nums, int left, int right) {
        
        int pivot = nums[right];
        int i = left;
        
        for(int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        
        swap(nums, i, right);
        return i;
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
    
}
