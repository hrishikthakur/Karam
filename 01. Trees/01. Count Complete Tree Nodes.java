// https://leetcode.com/problems/count-complete-tree-nodes

class Solution {
    
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int lc = countNodes(root.left);    
        int rc = countNodes(root.right);
        return lc + rc + 1;
    }
}
