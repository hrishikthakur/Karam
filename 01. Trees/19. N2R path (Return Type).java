class Solution
{
    public static ArrayList<Integer> N2R(Node root, int target){
        if(root == null) return null;
        if(root.data == target) return new ArrayList<>();
        
        ArrayList<Integer> left = N2R(root.left, target);
        if(left != null){
          left.add(root.data);
          return left;
        } 
        
        ArrayList<Integer> right = N2R(root.right, target);
        if(right != null){
          right.add(root.data);
          return right;
        } 
        
        return null;
    }
    
    public static ArrayList<Integer> Ancestors(Node root, int target)
    {
        ArrayList<Integer> res = N2R(root, target);
        return res;
    }
}
