// https://practice.geeksforgeeks.org/problems/max-and-min-element-in-binary-tree/1/

class Solution{
    public static int findMax(Node root){
        if(root == null) return -1;
        if(root.left == null && root.right == null) return root.data;
        
        int lMax = findMax(root.left);
        int rMax = findMax(root.right);
        
        return Math.max(root.data, Math.max(lMax, rMax));
    }
    public static int findMin(Node root){
        if(root == null) return Integer.MAX_VALUE;

        if(root.left == null && root.right == null) return root.data;
        
        int lMin = findMin(root.left);
        int rMin = findMin(root.right);
        
        return Math.min(lMin, Math.min(root.data, rMin));
    }
}
