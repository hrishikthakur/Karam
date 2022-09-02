class Solution {
    
    // Even list k liye ek pointer pehle rokna hai
    static ListNode middle(ListNode head){
        if(head == null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){ // odd length && even length
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    static ListNode mergeTwoLists(ListNode head1, ListNode head2){
        if(head1 == null && head2 == null) return null;
        if(head1 == null || head2 == null) return (head1 == null) ? head2 : head1;
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy, tail = dummy;
        
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                tail.next = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        tail.next = (head1 == null) ? head2 : head1;
        return dummy.next;
    }
    
    static ListNode helper(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode mid = middle(head);
        ListNode midNext = mid.next;
        mid.next = null;
        
        ListNode l1 = helper(head);
        ListNode l2 = helper(midNext);
        
        return mergeTwoLists(l1, l2);
    }
    
    public ListNode sortList(ListNode head) {
        return helper(head);
    }
}
