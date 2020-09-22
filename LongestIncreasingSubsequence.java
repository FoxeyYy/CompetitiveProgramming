public class Solution {

    //Space: O(n)  where n is nums size
    //Time: O(nlogn) where n is nums size
    public int lengthOfLIS(int[] nums) {
        
        int[] memo = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            
            int i = Arrays.binarySearch(memo, 0, len, num);
            if (i < 0) i = -(i + 1);
            
            memo[i] = num;
            if (i == len) len++;
            
        }
        return len;
    }
    
}
