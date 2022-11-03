class Solution {
    
    int totalTilt = 0;
    public int findTiltHelper(TreeNode root) {
        if(root == null) return 0;

        int lSum = findTiltHelper(root.left);
        int rSum = findTiltHelper(root.right);
        int tilt = Math.abs(lSum - rSum);
        
        totalTilt += tilt;
        
        return lSum + rSum + root.val;
    }
    
    public int findTilt(TreeNode root){
        findTiltHelper(root);
        return totalTilt;
    }
}
