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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> traversal = new LinkedList<Integer>();        
        Stack<TreeNode> nextNodes = new Stack<>();
        
        TreeNode current = root;
        
        while(current != null || !nextNodes.empty()) {
                                    
            while (current != null) {
                nextNodes.push(current);
                current = current.left;
            }
            
            current = nextNodes.pop();
            traversal.add(current.val);
            current = current.right;
            
        }
        
        return traversal;
        
    }
    
    private void inorderTraversalRec(TreeNode root, List<Integer> traversal) {
        if (root == null) return;
        
        if (root.left != null) inorderTraversal(root.left, traversal);   
        traversal.add(root.val);   
        if (root.right != null) inorderTraversal(root.right, traversal);    

    }
    
}
