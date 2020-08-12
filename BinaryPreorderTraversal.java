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
    public List<Integer> preorderTraversal(TreeNode root) {
                
        Stack<TreeNode> nextNodes = new Stack<>();
        List<Integer> traversal = new LinkedList<>();
        
        if (root == null) return traversal;
        
        nextNodes.push(root);
        
        while(!nextNodes.empty()) {
            
            TreeNode currentNode = nextNodes.pop();
            traversal.add(currentNode.val);
            
            if (currentNode.right != null) nextNodes.push(currentNode.right);
            if (currentNode.left != null) nextNodes.push(currentNode.left);

        }
        
        return traversal;
        
    }
}
