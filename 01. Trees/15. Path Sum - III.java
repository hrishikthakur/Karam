// O(n ^ 2) -> Each node can provide a valid targetSum
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

// O(n) -> Using the prefix array technique
class Solution {
    HashMap<Long, Integer> freq;
    public int helper(TreeNode root, int targetSum, long prefix){
        if(root == null) return 0;

        prefix += root.val;
        int count = (freq.containsKey(prefix - targetSum)) ? freq.get(prefix - targetSum) : 0;
        freq.put(prefix, freq.getOrDefault(prefix, 0) + 1);

        count += helper(root.left, targetSum, prefix);
        count += helper(root.right, targetSum, prefix);

        freq.put(prefix, freq.getOrDefault(prefix, 0) - 1); // backtrack
        return count;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        freq = new HashMap<>();
        freq.put(0l, 1);
        return helper(root, targetSum, 0l);
    }
}
