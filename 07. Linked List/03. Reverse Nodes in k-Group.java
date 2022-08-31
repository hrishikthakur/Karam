// getLength(ListNode head) & addFirst(ListNode head, ListNode node)
// these will be required to complete the problem
class Solution {
    
    public static int getLength(ListNode head){
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        return length;
    }
    
    static ListNode grpHead = null;
    static ListNode grpTail = null;
    public static void addFirst(ListNode node){
        if(grpHead == null){
            grpHead = node;
            grpTail = node;
        }else{
            node.next = grpHead;
            grpHead = node;
        }
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        
        ListNode newHead = null;
        ListNode newTail = null;
        
        int length = getLength(head);
        ListNode curr = head;
        
        while(length >= k){
            int grp = k;
            while(grp-- > 0){
                ListNode ahead = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = ahead;
            }
            
            if(newHead == null){
                newHead = grpHead;
                newTail = grpTail;
            }else{
                newTail.next = grpHead;
                newTail = grpTail;
            }
            
            grpHead = null;
            grpTail = null;
            length -= k;
        }
        
        newTail.next = curr;
        return newHead;
    }
}
