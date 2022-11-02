// https://leetcode.com/problems/symmetric-tree/

class Solution {
    
    public boolean isMirror(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null) return true;
        if(r1 != null && r2 != null && r1.val == r2.val){
            return isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left);
        }
        
        return false;
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }
}
