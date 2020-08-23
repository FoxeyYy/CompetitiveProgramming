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
    
    int current = 0;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        
        return bst(preorder, Integer.MAX_VALUE);
        
    }
    
    private TreeNode bst(int[] preorder, int limit) {
        
        if (current == preorder.length || preorder[current] > limit) return null;
        
        TreeNode node = new TreeNode(preorder[current]);
        current++;
        
        node.left = bst(preorder, node.val);
        node.right = bst(preorder, limit);
        
        return node;
        
    }
}
