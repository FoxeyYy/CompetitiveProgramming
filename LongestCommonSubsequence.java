class Solution {
    
    //Time: O(n*m) where n is text1 size and m is text2 size
    //Space: O(n*m) where n is text1 size and m is text2 size
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] longestSoFar = new int[text1.length() + 1][text2.length() + 1];
        
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                
                char char1 = text1.charAt(i - 1);
                char char2 = text2.charAt(j - 1);
                
                if (char1 == char2) {
                    longestSoFar[i][j] = 1 + longestSoFar[i-1][j-1];
                } else {
                    longestSoFar[i][j] = Math.max(
                        longestSoFar[i-1][j], 
                        longestSoFar[i][j-1]
                    );
                }                
            }
        }
        
        return longestSoFar[text1.length()][text2.length()];
        
    }
}
