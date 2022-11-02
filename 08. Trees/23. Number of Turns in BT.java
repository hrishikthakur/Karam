class Solution
{
    
    public static ArrayList<Node> n2r(Node root, int target){
        if(root == null) return null;
        if(root.data == target){
            ArrayList<Node> res = new ArrayList<>();
            res.add(root);
            return res;
        }
        ArrayList<Node> left = n2r(root.left, target);
        if(left != null){
            left.add(root);
            return left;
        }
        ArrayList<Node> right = n2r(root.right, target);
        if(right != null){
            right.add(root);
            return right;
        }
        return null;
    }
    
    public static Node LCA(Node root, int t1, int t2){
        if(root == null) return null;
        ArrayList<Node> p1 = n2r(root, t1);
        ArrayList<Node> p2 = n2r(root, t2);
        Node LCA = null;
        int i = p1.size() - 1, j = p2.size() - 1;
        while(i >= 0 && j >= 0){
            if(p1.get(i) != p2.get(j)) break;
            LCA = p1.get(i);
            i--;
            j--;
        }
        return LCA;
    }
    
    public static String LCAtoTargetPath(Node node, int target, String psf){
        if(node == null) return null;
        if(node.data == target){
            return psf;
        }
        String left = LCAtoTargetPath(node.left, target, psf + 'l');
        if(left != null) return left;
        String right = LCAtoTargetPath(node.right, target, psf + 'r');
        if(right != null) return right;
        
        return null;
    }
    
    static int NumberOfTurns(Node root, int first, int second)
    {
        Node LCA = LCA(root, first, second);
        String p1 = LCAtoTargetPath(LCA, first, "");
        String p2 = LCAtoTargetPath(LCA, second, "");
        
        String p11 = "";
        for(int i = 0; i < p1.length(); i++){
            p11 = p1.charAt(i) + p11;
        }
        
        String s = p11 + p2;
        int turnCount = 0;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) != s.charAt(i + 1)) turnCount++;
        }
        
        return turnCount;
    }
}
