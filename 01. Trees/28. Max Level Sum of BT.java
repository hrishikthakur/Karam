// Using DFS
class Solution {
    ArrayList<Integer> levelSum;
    public void DFS(TreeNode root, int level){
        if(root == null) return;
        if(level < levelSum.size()) levelSum.set(level, levelSum.get(level) + root.val);
        else levelSum.add(root.val);
        DFS(root.left, level + 1);
        DFS(root.right, level + 1);
    }
    public int maxLevelSum(TreeNode root) {
        levelSum = new ArrayList<>();
        levelSum.add(-1); // 1 based indexing
        DFS(root, 1);
        int maxLevel = 1;
        for(int i = 1; i < levelSum.size(); i++){
            if(levelSum.get(i) > levelSum.get(maxLevel)) maxLevel = i;
        }
        return maxLevel;
    }
}
