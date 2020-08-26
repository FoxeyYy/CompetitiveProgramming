/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int sol = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        dfs(root);
        
        return sol;
    }
    
    private int dfs(TreeNode root) {
        
        if (root == null) return 0;
        
        int maxSumLeft = Math.max(0, dfs(root.left));
        int maxSumRight = Math.max(0, dfs(root.right));
                
        sol = Math.max(sol, root.val + maxSumLeft + maxSumRight);
        
        return Math.max(
            root.val + maxSumLeft,
            root.val + maxSumRight
        );
        
    }
}
