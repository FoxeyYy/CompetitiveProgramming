class Solution {
    
    public int coinChange(int[] coins, int amount) {
        
        int[] memo = new int[amount + 1];
        
        Arrays.fill(memo, amount + 1);
        
        memo[0] = 0;
        
        for(int i = 1; i <= amount; i++) {
            for(int coin: coins) {
                if(coin <= i) {
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
                }
            }
        }
        
        return memo[amount] > amount ? -1 : memo[amount];
        
    }

}
