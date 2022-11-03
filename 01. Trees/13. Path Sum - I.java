class Solution {
    
    public boolean helper(TreeNode root, int targetSum){
        if(root == null) return false;
        if(root.left == null && root.right == null) return targetSum - root.val == 0;
        
        if(helper(root.left, targetSum - root.val) || helper(root.right, targetSum - root.val)) return true;
        return false;
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum);
    }
}
