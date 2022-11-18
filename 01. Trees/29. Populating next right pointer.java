// BFS -> Using extra space (Queue)
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node popped = q.remove();
                if(i == size - 1) popped.next = null;
                else popped.next = q.peek();
                if(popped.left != null) q.add(popped.left);
                if(popped.right != null) q.add(popped.right);
            }
        }
        return root;
    }
}

// BFS using DFS -> Without using extra space
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node curr = root;
        curr.next = null;
        while(curr != null){ // travel on the ith level
            Node head = null, tail = null;
            // construct the (i + 1)th level
            while(curr != null){
                if(curr.left != null){
                    if(head == null)
                        head = tail = curr.left;
                    else{
                        tail.next = curr.left;
                        tail = tail.next;
                    }   
                }
                if(curr.right != null){
                    if(head == null)
                        head = tail = curr.right;
                    else{
                        tail.next = curr.right;
                        tail = tail.next;
                    }
                }
                curr = curr.next; 
            }
            curr = head; // update curr as the of the (i + 1)th level
        }
        return root;
    }
}
