static int minHL = Integer.MAX_VALUE;
static int maxHL = Integer.MIN_VALUE;
public static void dfs(TreeNode root, int hl){
    if(root == null) return;
    minHL = Math.min(minHL, hl);
    maxHL = Math.max(maxHL, hl);
    dfs(root.left, hl - 1);
    dfs(root.right, hl + 1);
}

public static int width(TreeNode root) {
    dfs(root, 0);
    return maxHL - minHL + 1;
}
