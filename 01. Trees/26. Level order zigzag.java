// Using a single Queue
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        int level = 1;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(q.size() > 0){
            int counter = q.size();
            int[] ans = new int[q.size()];
            for(int i = 0; i < counter; i++){
                TreeNode popped = q.remove();

                if(level % 2 == 1) ans[i] = popped.val;
                else ans[counter - i - 1] = popped.val;

                if(popped.left != null) q.add(popped.left);
                if(popped.right != null) q.add(popped.right);
            }
            level++;
            List<Integer> temp = new ArrayList<>();
            for(Integer node : ans)
                temp.add(node); 
            res.add(temp);
        }

        return res;
    }
}
