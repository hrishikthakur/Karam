class Solution {
    
    public void dfs(TreeNode root, String psf, int[] ans){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans[0] += Integer.parseInt(psf + root.val);
        }
        dfs(root.left, psf + root.val, ans);
        dfs(root.right, psf + root.val, ans);
    }
    
    public int sumNumbers(TreeNode root) {
        int[] ans = new int[1];
        dfs(root, "", ans);
        return ans[0];
    }
}
