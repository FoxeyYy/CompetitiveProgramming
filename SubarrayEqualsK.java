class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int pref = 0;
        int count = 0;
        Map<Integer, Integer> countPref = new HashMap<>();
        
        countPref.put(0, 1);
        
        for(Integer num: nums) {
            pref += num;
            int needed = pref - k;
            
            count += countPref.getOrDefault(needed, 0);
            int prefCount = countPref.getOrDefault(pref, 0) + 1;
            countPref.put(pref,  prefCount);
        }
        
        return count;
        
    }
}
