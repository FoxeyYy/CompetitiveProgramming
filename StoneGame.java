class Solution {
    public boolean stoneGame(int[] piles) {
        
        int totalCount = 0;
        
        for(Integer pile: piles) {
            totalCount += pile;
        }
        
        Integer[][] memo = new Integer[piles.length][piles.length];
                
        return stoneGame(piles, 0, 0, 1, memo) > 0;
        
    }
    
    private int stoneGame(
        int[] piles, 
        int left,
        int right,
        int isAlexTurn,
        Integer[][] memo
    ) {
        
        if (left == right) return piles[left] * isAlexTurn;
        if (memo[left][right] != null) return memo[left][right];
                
        int maxScore = Integer.MIN_VALUE;
        
        int subScore = stoneGame(piles, left + 1, right, -1*isAlexTurn, memo) + piles[left] * isAlexTurn;
        maxScore = Math.max(maxScore, subScore);
        
        subScore = stoneGame(piles, left, right - 1, -1*isAlexTurn, memo) + piles[right] * isAlexTurn;
        maxScore = Math.max(maxScore, subScore);
        
        memo[left][right] = maxScore;
                                
        return maxScore;
        
    }
}
