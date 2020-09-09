class Solution {

    //Time: O(n^2), where n is s length
    //Space: O(1)
    public String longestPalindrome(String s) {
        
        String longestPal = "";
        
        for(int i = 0; i < s.length(); i++) {
            int offset1 = expandOffset(s, i, i);
            int offset2 = expandOffset(s, i, i + 1);
            
            String subs = "";
            
            int maxOffset = Math.max(offset1, offset2);
            
            if (offset2 > offset1) {
                subs = s.substring(i - maxOffset + 1, i + maxOffset + 1);
            } else {
                subs = s.substring(i - maxOffset, i + maxOffset + 1);   
            }

            if (longestPal.length() < subs.length()) longestPal = subs;
            
        }
        
        return longestPal;
        
    }
    
    private int expandOffset(String s, int left, int right) {
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return (right - left - 1) / 2;
        
    }

}
