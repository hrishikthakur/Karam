// https://leetcode.com/problems/maximum-depth-of-binary-tree/

class Solution {
    
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        
        return Math.max(lh, rh) + 1;
    }
}
