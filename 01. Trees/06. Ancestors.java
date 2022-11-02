// HEAP MOVER
// The find approach -> boolean return type
class Solution
{
    public static boolean helper(Node root, int target, ArrayList<Integer> r2n){
        if(root == null) return false;
        if(root.data == target) return true;
        
        r2n.add(root.data);
        
        if(helper(root.left, target, r2n)) return true;
        if(helper(root.right, target, r2n)) return true;
        
        r2n.remove(r2n.size() - 1);
        return false;
    }
    
    public static ArrayList<Integer> Ancestors(Node root, int target)
    {
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, target, res);
        Collections.reverse(res);
        return res;
    }
}

// RETURN TYPE
// Returning the ArrayList -> inefficient cause overhead of copying
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
