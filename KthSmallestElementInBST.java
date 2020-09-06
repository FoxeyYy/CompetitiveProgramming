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
    
    private class Meta {
        
        int val;
        int pos;
        
        public Meta(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
        
    }
    
    public int kthSmallest(TreeNode root, int k) {
        
        Meta meta = inorder(root, k, null);
        return meta.val;
        
    }
    
    private Meta inorder(TreeNode root, int k, Meta prev) {
        
        if (root == null) return prev;
        
        Meta left = inorder(root.left, k, prev);
        
        if (left != null && left.pos == k) return left;
        
        if (left == null && prev == null) prev = new Meta(root.val, 0);
        if (left == null && prev != null) prev = new Meta(root.val, prev.pos + 1);
        if (left != null) prev = new Meta(root.val, left.pos + 1);
        
        return inorder(root.right, k, prev);
        
    }
}
