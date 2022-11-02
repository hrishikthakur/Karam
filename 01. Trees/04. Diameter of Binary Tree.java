// O(n ^ 2)
class Solution {
    
    public int height(TreeNode root){
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    
    public int diameter(TreeNode root) {
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        
        return Math.max(rh + lh + 1, Math.max(ld, rd));
    }
    
    public int diameterOfBinaryTree(TreeNode root){
        if(root == null) return 0; // if root null, dia = 0 both in terms of nodes and edges
        return diameter(root) - 1;
    }
}

// O(n) -> Global Variable / Travel and change
// Update global dia while returning lh & rh for each node
class Solution {
    
    int diameter;
    
    public int height(TreeNode root){
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        diameter = Math.max(diameter, lh + rh + 1);
        return Math.max(lh, rh) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter - 1;
    }
}

// O(n) -> Using Pair Class
class Solution {
    
    class Pair{
        int height;
        int diameter;
        Pair(){
            height = 0;
            diameter = 0;
        }
    }
    
    public Pair helper(TreeNode root){
        if(root == null) return new Pair();
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        Pair curr = new Pair();
        curr.height = Math.max(left.height, right.height) + 1;
        curr.diameter = Math.max(left.height + right.height + 1, Math.max(left.diameter, right.diameter));
        return curr;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return helper(root).diameter - 1;
    }
}
