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
