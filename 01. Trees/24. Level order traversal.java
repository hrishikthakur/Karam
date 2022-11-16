class Solution
{
    static void helper(Node root, ArrayList<Integer> res){
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() > 0){
            Node popped = q.remove();
            res.add(popped.data);
            if(popped.left != null) q.add(popped.left);
            if(popped.right != null) q.add(popped.right);
        }
        return;
    }
    static ArrayList <Integer> levelOrder(Node node) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        helper(node, res);
        return res;
    }
}
