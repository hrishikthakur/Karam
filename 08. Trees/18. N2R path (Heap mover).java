class Solution
{
    
    // this is basically the find function
    public static boolean getN2R(Node root, int target, ArrayList<Integer> res){
        if(root == null) return false;
        if(root.data == target){
            // res.add(root.data);  // target node with (node.data == target) is found
            return true;
        }
        boolean ans = getN2R(root.left, target, res) || getN2R(root.right, target, res);
        if(ans) res.add(root.data); // postorder me ... the target node has been found, now we are backtracking
        return ans;
    }
    
    public static ArrayList<Integer> Ancestors(Node root, int target)
    {
        ArrayList<Integer> res = new ArrayList<>();
        getN2R(root, target, res);
        return res;
    }
}
