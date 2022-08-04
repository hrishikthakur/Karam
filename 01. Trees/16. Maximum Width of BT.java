class Solution {
    
    public static class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        LinkedList<Pair> q = new LinkedList<>();
        q.addLast(new Pair(root, 0));
        while(q.size() > 0){
            int size = q.size();
            int si = q.getFirst().idx; // si is updated only at the beginning of a level
            int ei = q.getFirst().idx;
            while(size-- > 0){ // RWA
                // remove node
                Pair removedPair = q.removeFirst();
                // work
                ei = removedPair.idx; // ei is updated after every removedPair is generated
                // add children
                if(removedPair.node.left != null) q.addLast(new Pair(removedPair.node.left, ei * 2 + 1));
                if(removedPair.node.right != null) q.addLast(new Pair(removedPair.node.right, ei * 2 + 2));
            }
            maxWidth = Math.max(maxWidth, ei - si + 1);
        }
        
        return maxWidth;
    }
}
