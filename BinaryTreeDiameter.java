class Solution {
    
    int sol;
    
    public int diameterOfBinaryTree(TreeNode root) {
           
        sol = 0;
        
        height(root);
        
        return sol;
        
    }
    
    private int height(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        sol = Math.max(
            sol,
            leftHeight + rightHeight
        );
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
