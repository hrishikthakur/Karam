// ******************************** O(N^2) **********************************
class Solution {
    
    public int height(TreeNode root){
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (node == null) return 0;

        int lDia = diameterOfBinaryTree(node.left);
        int rDia = diameterOfBinaryTree(node.right);

        // In the postorder again a recursive function is called making in O(N^2)
        int lh = height(node.left);
        int rh = height(node.right);
        int dia = lh + rh + 2;

        return Math.max(dia, Math.max(lDia, rDia));
    }
}

// ******************************** O(N) - Using Pair class **********************************
class Solution {
    
    class Pair{
        int height;
        int diameter;
        Pair(){
            height = -1;
            diameter = 0;
        }
    }
    
    public Pair helper(TreeNode root) {
        if(root == null) return new Pair();
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        Pair curr = new Pair();
        curr.height = Math.max(left.height, right.height) + 1;
        curr.diameter = Math.max(left.height + right.height + 2, Math.max(left.diameter, right.diameter));
        return curr;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).diameter;
    }
    
}
