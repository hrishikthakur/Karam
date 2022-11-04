class Solution {
    public int helper(TreeNode root, long targetSum){
        if(root == null) return 0;
        int count = 0;
        if(root.val == targetSum) count++;
        count += helper(root.left, targetSum - root.val) + helper(root.right, targetSum - root.val);
        return count;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return helper(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
}
