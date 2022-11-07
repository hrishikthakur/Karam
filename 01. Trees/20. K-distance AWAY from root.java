// O(k * n) & O(N) for r2nPath
class Solution {
    public boolean path(TreeNode root, TreeNode target, ArrayList<TreeNode> r2nPath){
        if(root == null) return false;
        if(root.val == target.val){
            r2nPath.add(root);
            return true;
        }
        r2nPath.add(root);
        if(path(root.left, target, r2nPath)) return true;
        if(path(root.right, target, r2nPath)) return true;
        r2nPath.remove(r2nPath.size() - 1);
        return false;
    }
    public void kLevelDown(TreeNode root, TreeNode blocker, int k, ArrayList<Integer> res){
        if(k == -1 || root == null || root == blocker) return;
        if(k == 0){
            res.add(root.val);
            return;
        }
        kLevelDown(root.left, blocker, k - 1, res);
        kLevelDown(root.right, blocker, k - 1, res);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> r2nPath = new ArrayList<>();
        if(!path(root, target, r2nPath)) return new ArrayList<>();

        r2nPath.add(null); // blocker node to the given root will be none
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = r2nPath.size() - 2; i >= 0; i--){
            TreeNode curr = r2nPath.get(i);
            TreeNode blocker = r2nPath.get(i + 1);
            kLevelDown(curr, blocker, k, res);
            k--;
        }
        return res;
    }
}

// O(N), Without extra space
class Solution {
    public void kLevelDown(TreeNode root, TreeNode blocker, int k, List<Integer> res){
        if(k == -1 || root == null || root == blocker) return;
        if(k == 0){
            res.add(root.val);
            return;
        }
        kLevelDown(root.left, blocker, k - 1, res);
        kLevelDown(root.right, blocker, k - 1, res);
    }
    public int DFS(TreeNode root, TreeNode target, int k, List<Integer> res){
        if(root == null) return -1;
        if(root == target){
            kLevelDown(root, null, k, res);
            return 1;
        }
        int left = DFS(root.left, target, k, res); // left subtree has target node
        if(left >= 0){
            kLevelDown(root, root.left, k - left, res);
            return left + 1;
        }
        int right = DFS(root.right, target, k, res); // right subtree has target node
        if(right >= 0){
            kLevelDown(root, root.right, k - right, res);
            return right + 1;
        }
        return -1;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        DFS(root, target, k, res);
        return res;
    }
}
