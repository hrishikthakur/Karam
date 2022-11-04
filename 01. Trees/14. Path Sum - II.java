class Solution {

    List<List<Integer>> res;

    public void helper(TreeNode root, int targetSum, List<Integer> ans){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans.add(root.val);
            if(targetSum - root.val == 0){
                res.add(new ArrayList<>(ans));
            }
            ans.remove(ans.size() - 1);
            return;
        }

        ans.add(root.val);
        helper(root.left, targetSum - root.val, ans);
        helper(root.right, targetSum - root.val, ans);
        ans.remove(ans.size() - 1);
        return;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>());
        return res;
    }
}
