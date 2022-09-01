class Solution {
    public ListNode middle(ListNode head){
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode prev = null, curr = head, ahead = head.next;
        
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = ahead;
            if(ahead != null) ahead = ahead.next;
        }
        
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode mid = middle(head);
        ListNode head2 = reverse(mid.next);
        
        ListNode curr = head;
        ListNode curr2 = head2;
        while(curr != null && curr2 != null){
            if(curr.val != curr2.val) return false;
            
            curr = curr.next;
            curr2 = curr2.next;
        }
        return true;
    }
}
