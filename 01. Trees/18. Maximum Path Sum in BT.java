class Solution {
    int maxPathSum;
    public int helper(TreeNode root){
        if(root == null) return 0;
      
        int leftPathSum = helper(root.left);
        int rightPathSum = helper(root.right);
      
        int currPathSum = root.val + ((leftPathSum > 0) ? leftPathSum : 0) + ((rightPathSum > 0) ? rightPathSum : 0);
        maxPathSum = Math.max(maxPathSum, currPathSum);
      
        return root.val + Math.max(0, Math.max(leftPathSum, rightPathSum));
    }
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        helper(root);
        return maxPathSum;
    }
}
