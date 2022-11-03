class Solution {
    
    // helper -> checks if head passed can generate the given LL
    public boolean helper(ListNode head, TreeNode root){
        if(head == null) return true;
        if(root == null) return false;
        if(head.val == root.val){
            return helper(head.next, root.left) || helper(head.next, root.right);
        }
        return false;
    }
    
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null) return false;
        // can head generate LL || can root.left as head generate LL || can root.right as head generate LL
        return helper(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}
