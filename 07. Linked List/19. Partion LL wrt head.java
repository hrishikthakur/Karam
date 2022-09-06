// Partition wrt head
// REGION -> [ < x, >= x]
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode headL = new ListNode(-1);
        ListNode tailL = headL;
        ListNode headR = new ListNode(-1);
        ListNode tailR = headR;
        
        while(head != null){
            
            // this if is the entire saar of the problem
            if(head.val < x){
                tailL.next = head;
                tailL = tailL.next;
            }else{
                tailR.next = head;
                tailR = tailR.next;
            }
            head = head.next;
        }
        
        tailL.next = headR.next;
        tailR.next = null;
        
        return headL.next;
    }
}
