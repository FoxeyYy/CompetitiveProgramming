public class Solution {
    
    //Time complexity: O(n^2) where n is nums size
    //Space complexity: O(logn) where n is nums size on average
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3) return result;

        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
                        
            int left = i + 1, right = nums.length - 1;

            while(left < right) {
                                                
                int sum = nums[left] + nums[i] + nums[right];
                
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    ArrayList<Integer> elem = new ArrayList<Integer>(3);

                    elem.add(nums[left]);
                    elem.add(nums[i]);
                    elem.add(nums[right]);

                    result.add(elem);
                    do {
                        left++;
                    } while(left < right && nums[left] == nums[left - 1]);
                }
                
            }
            
        }
        
        return result;
        
    }
    
}
