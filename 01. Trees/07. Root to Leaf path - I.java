class Solution {
    
    public void dfs(TreeNode root,String psf, ArrayList<String> res){
        if(root == null) return;
        if(root.left == null && root.right == null){
            // leaf node
            psf = psf + root.val;
            res.add(psf);
        }
        dfs(root.left, psf +  root.val + "->", res);
        dfs(root.right, psf +  root.val + "->", res);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        dfs(root,"", res);
        return res;
    }
}
