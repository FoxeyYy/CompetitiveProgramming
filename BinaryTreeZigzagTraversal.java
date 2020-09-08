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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        boolean leftToRight = true;
        
        if (root != null) current.add(root);
        
        List<List<Integer>> traversal = new LinkedList<>();
        
        while (!current.empty()) {
            
            List<Integer> level = new LinkedList<>();
                        
            while(!current.empty()) {
                TreeNode node = current.pop();
                
                level.add(node.val);
                
                if (leftToRight) {
                    if (node.left != null) next.push(node.left);
                    if (node.right != null) next.push(node.right);
                } else {
                    if (node.right != null) next.push(node.right);
                    if (node.left != null) next.push(node.left);
                }
            }
            
            traversal.add(level);
                        
            //Swap current <> next
            Stack<TreeNode> tmp = current;
            current = next;
            next = tmp;
            
            leftToRight = !leftToRight;
            
        }
        
        return traversal;
        
    }
}
