class Solution {
    
    long maxProduct; 
    long totalTreeSum;
    
    // convert tree into a sum tree
    public int sumTree(TreeNode root){
        if(root == null) return 0;
        int lSum = sumTree(root.left);
        int rSum = sumTree(root.right);
        root.val = lSum + rSum + root.val;
        return root.val;
    }
    
    public void dfs(TreeNode root){
        if(root == null) return;
        
        long lSubtreeSum = (root.left == null) ? 0 : root.left.val;
        maxProduct = Math.max(maxProduct, lSubtreeSum * (totalTreeSum - lSubtreeSum)); // maxProduct on splitting through the left edge
        long rSubtreeSum = (root.right == null) ? 0 : root.right.val;
        maxProduct = Math.max(maxProduct, rSubtreeSum * (totalTreeSum - rSubtreeSum)); // right edge
        
        dfs(root.left);
        dfs(root.right);
    }
    
    public int maxProduct(TreeNode root) {
        if(root == null) return 0;
        
        maxProduct = 0;
        totalTreeSum = sumTree(root);
        
        dfs(root);
        return (int)(maxProduct % (1e9 + 7)); // 1 * 9 (0)s + 7
    }
}
