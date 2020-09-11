class Solution {

    //Space: O(n)
    //Time: O(n) average, O(n^2) worst case
class Solution {
    int[] unique;
    Map<Integer, Integer> count;

    private void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }

    private int partition(int left, int right, int pivot_index) {
        
        int pivot_frequency = count.get(unique[pivot_index]);
        
        // 1. move pivot to end
        swap(pivot_index, right);
        int i = left;

        // 2. move all less frequent elements to the left
        for (int j = left; j <= right; j++) {
            if (count.get(unique[j]) < pivot_frequency) {
                swap(i, j);
                i++;
            }
        }

        // 3. move pivot to its final place
        swap(i, right);

        return i;
    }
    
    private void quickselect(int left, int right, int k_smallest) {

        if (left == right) return;
        
        Random random = new Random();
        int pivot_index = left + random.nextInt(right - left); 

        pivot_index = partition(left, right, pivot_index);

        if (k_smallest == pivot_index) {
            return;    
        } else if (k_smallest < pivot_index) {
            quickselect(left, pivot_index - 1, k_smallest);     
        } else {
            quickselect(pivot_index + 1, right, k_smallest);  
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        
        count = new HashMap();
        for (int num: nums) {
            int cnt = count.getOrDefault(num, 0) + 1;
            count.put(num, cnt);
        }
        
        int n = count.size();
        unique = new int[n]; 
        int i = 0;
        for (int num: count.keySet()) {
            unique[i] = num;
            i++;
        }
        
        quickselect(0, n - 1, n - k);

        return Arrays.copyOfRange(unique, n - k, n);
    }
}
