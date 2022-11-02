class Solution {
    
    public ArrayList<TreeNode> N2R(TreeNode root, TreeNode target){
        if(root == null) return null;
        if(root.val == target.val){
           ArrayList<TreeNode> ans = new ArrayList<>();
            ans.add(target);
            return ans;
        }
        ArrayList<TreeNode> left = N2R(root.left, target);
        if(left != null){
            left.add(root);
            return left;
        }
        ArrayList<TreeNode> right = N2R(root.right, target);
        if(right != null){
            right.add(root);
            return right;
        }
        return null;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> p1 = N2R(root, p);
        ArrayList<TreeNode> p2 = N2R(root, q);
        
        TreeNode LCA = null;
        int i = p1.size() - 1, j = p2.size() - 1;
        while(i >= 0 && j >= 0){
            if(p1.get(i) != p2.get(j)) break;
            LCA = p1.get(i);
            i--;
            j--;
        }
        
        return LCA;
    }
}
