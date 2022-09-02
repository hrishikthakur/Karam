class Solution {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy, tail = dummy;

        int carry = 0;
        while(head1 != null || head2 != null || carry == 1){
            int digit1 = (head1 != null) ? head1.val : 0;
            int digit2 = (head2 != null) ? head2.val : 0;
            
            ListNode node = new ListNode((digit1 + digit2 + carry) % 10);
            tail.next = node;
            tail = tail.next;
            
            carry = (digit1 + digit2 + carry) / 10;
            
            if(head1 != null) head1 = head1.next;
            if(head2 != null) head2 = head2.next;
        }
        
        return dummy.next;
    }
}
