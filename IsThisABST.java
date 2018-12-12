/*
  The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {
        
        // If we retrieve tree as in-order and then we check if list if sorted we can find out if this is a BST
        List<Integer> tree = buildTree(root);
        
        int prev = Integer.MIN_VALUE;
        
        for (int data: tree) {
            if (data <= prev) return false;
            prev = data;
        }
        
        return true;
        
    }

    // Build tree as in-order
    List<Integer> buildTree(Node root) {
        
        List<Integer> tree = new ArrayList<>();
        
        int data = root.data;
        Node left = root.left;
        Node right = root.right;
        
        if (left != null) {
            tree.addAll(buildTree(left));
        }
        
        tree.add(data);
        
        if (right != null) {
            tree.addAll(buildTree(right));
        }
        
        return tree;
    }
