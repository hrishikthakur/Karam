// O(n ^ 2) -> finding height of each node(n) and checking isBalanced for each node(n)
class Solution {
    
    public int height(TreeNode root){
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        if(lh - rh > 1 || lh - rh < -1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}

// O(n) -> Using pair class
class Solution {
    
    class Pair{
        int height;
        boolean isBalanced;
        Pair(){
            height = 0;
            isBalanced = true; // single node is always balanced
        }
    }
    
    public Pair helper(TreeNode root) {
        if(root == null) return new Pair();
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        Pair curr = new Pair();
        curr.height = Math.max(left.height, right.height) + 1;
        curr.isBalanced = left.isBalanced && right.isBalanced && (Math.abs(left.height - right.height) <= 1);
        // if left, right and ourNode, all are balanced
        
        return curr;
    }
    
    public boolean isBalanced(TreeNode root){
        return helper(root).isBalanced;
    }
}
