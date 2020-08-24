class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        
        int answer = 0;
        
        for(int i = 30; i >= 0; i--) {
            if (((m >> i) & 1) != ((n >> i) & 1)) break;
            
            answer |= (m & (1 << i));
            
        }
        
        return answer;
        
    }
}
