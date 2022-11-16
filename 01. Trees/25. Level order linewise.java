// Using delimiter
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        Node marker = new Node(-1);
        q.add(marker);

        List<Integer> level = new ArrayList<>();
        while(q.size() > 0){
            Node popped = q.remove();
            if(popped == marker){
                res.add(level);
                level = new ArrayList<>();
                if(q.size() > 0) q.add(marker);
            }else{
                level.add(popped.val);
                for(Node child : popped.children){
                    q.add(child);
                }
            }
        }
        return res;
    }
}

// Size method
// Time:O(N), Space:O(N/2) best case(balanced tree)
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() > 0){
            int counter = q.size();
            List<Integer> level = new ArrayList<>();
            while(counter-- > 0){
                Node popped = q.remove();
                for(Node child : popped.children)
                    q.add(child);
                level.add(popped.val);
            }
            res.add(level);
        }
        return res;
    }
}
