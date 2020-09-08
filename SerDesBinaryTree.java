/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder builder = new StringBuilder();
        
        serialize(root, builder);
        
        builder.deleteCharAt(builder.length() - 1);        
        
        return builder.toString();
        
    }
    
    private void serialize(TreeNode root, StringBuilder builder) {
        
        if (root == null) {
            builder.append("#,");
            return;
        }
        
        builder.append(root.val + ",");
        
        serialize(root.left, builder);
                
        serialize(root.right, builder);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
                
        return deserialize(new LinkedList<>(Arrays.asList(data.split(","))));
        
    }
    
    private TreeNode deserialize(List<String> nodes) {
                        
        if (nodes.isEmpty()) return null;
        if (nodes.get(0).equals("#")) {
            nodes.remove(0);
            return null;
        }
        
        TreeNode current = new TreeNode(Integer.valueOf(nodes.get(0)));
        nodes.remove(0);
        
        TreeNode left = deserialize(nodes);        
        TreeNode right = deserialize(nodes);
        
        current.left = left;
        current.right = right;
        
        return current;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
