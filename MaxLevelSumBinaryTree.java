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
    
    // Time: O(n) where n is number of nodes
    // Space: O(n) where n is number of nodes
    public int maxLevelSum(TreeNode root) {
        
        int maxSum = Integer.MIN_VALUE, maxLevel = 0;
        Queue<TreeNode> 
            current = new LinkedList<>(), 
            next = new LinkedList<>();
        int currentLevel = 1, currentSum;
        
        current.add(root);
        
        while (!current.isEmpty()) {
            
            currentSum = 0;
            
            while (!current.isEmpty()) {
                TreeNode node = current.poll();
                currentSum += node.val;
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxLevel = currentLevel;
            }
                            
            currentLevel++;
            
            Queue<TreeNode> tmp = current;
            current = next;
            next = tmp;
            
        }
                
        return maxLevel;
    }
    
}
