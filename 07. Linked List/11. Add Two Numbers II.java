class Solution {
    
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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = reverse(l1);
        ListNode h2 = reverse(l2);
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        int carry = 0;
        while(h1 != null || h2 != null || carry == 1){
            int d1 = (h1 != null) ? h1.val : 0;
            int d2 = (h2 != null) ? h2.val : 0;
            
            ListNode node = new ListNode((d1 + d2 + carry) % 10);
            tail.next = node;
            tail = tail.next;
            
            carry = (d1 + d2 + carry) / 10;
            
            if(h1 != null) h1 = h1.next;
            if(h2 != null) h2 = h2.next;
        }
        
        ListNode res = reverse(dummy.next);
        return res;
    }
}
