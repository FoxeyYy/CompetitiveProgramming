class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> seen = new HashSet<>();
        
        while (n != 1) {
            
            int sum = 0;
            
            while(n != 0) {
                
                sum += (n % 10) * (n % 10);
                n /= 10;
                
            }
            
            n = sum;
            
            if (seen.contains(n)) return false;
            
            seen.add(n);
            
        }
        
        return true;
        
    }
}
