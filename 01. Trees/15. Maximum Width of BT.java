class Solution {
    int getMaxWidth(Node root) {
        int maxWidth = 0;
        LinkedList<Node> q = new LinkedList<>();
        q.addLast(root);
        while(q.size() > 0){
            int size = q.size();
            maxWidth = Math.max(maxWidth, size);
            while(size-- > 0){
                Node removedNode = q.removeFirst();
                if(removedNode.left != null) q.addLast(removedNode.left);
                if(removedNode.right != null) q.addLast(removedNode.right);
            }
        }
        
        return maxWidth;
    }
}
