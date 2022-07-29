// ****************************** O(N^2) ***************************************

// 1) Each nd every node has to chechked for "isBalanced"
class Solution {
    
    public int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh - rh) <= 1 && isBalanced(root.left) == true && isBalanced(root.right) == true) return true;
        return false;
    } 
}

// ****************************** O(N) ***************************************
class Solution {
    
    static class Pair{
        int height = 0;
        boolean isBalanced = true;
    }
    
    public Pair helper(TreeNode root){
        if(root == null) return new Pair();
        
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        Pair curr = new Pair();
        curr.height = Math.max(left.height, right.height) + 1;
        curr.isBalanced = (left.isBalanced && right.isBalanced) && (Math.abs(left.height - right.height) <= 1);
            
        return curr;
    }
    
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
}
