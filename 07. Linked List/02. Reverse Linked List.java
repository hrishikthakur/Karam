// Data Iterative -> O(N ^ 2) Time
class Solution {
    
    public ListNode getNodeAt(ListNode head, int idx){
        ListNode temp = head;
       for(int i = 0; i < idx; i++)
           temp = temp.next;
        return temp; 
    }
    
    public ListNode reverseList(ListNode head) {
        int size = 0;
        
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        
        int l = 0, r = size - 1;
        while(l < r){
            ListNode  left = getNodeAt(head, l);
            ListNode right = getNodeAt(head, r);
            
            int leftVal = left.val;
            left.val = right.val;
            right.val = leftVal;
            
            l++;r--;
        }
        return head;
    }
}

// Pointer Iterative -> O(N) Time: (Must Learn)
// 3 POINTER TECHNIQUE ... Think of 1st arrow ... Rest will follow
// Also node that ahead will reach null before curr
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode ahead = curr.next;
        
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = ahead;
            if(ahead != null) ahead = ahead.next;
        }
        
        return head = prev;
    }
}
