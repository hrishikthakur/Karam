// Using BFS -> Easy
// Time:O(N), Space:O(N)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode popped = q.remove();
                if(i == size - 1) res.add(popped.val);
                if(popped.left != null) q.add(popped.left);
                if(popped.right != null) q.add(popped.right);
            }
        }
        return res;
    }
}

// Using DFS -> important
class Solution {
    ArrayList<Integer> rightView;
    public void DFS(TreeNode root, int level){
        if(root == null) return;
        if(rightView.size() <= level) rightView.add(root.val);
        else rightView.set(level, root.val);
        DFS(root.left, level + 1);
        DFS(root.right, level + 1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        rightView = new ArrayList<>();
        if(root == null) return rightView;
        DFS(root, 0);
        return rightView;
    }
}
