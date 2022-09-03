public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false; // 0 node or 1 node
        if(head.next = head) return true; // self Referential node
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow) return true; // Cycle detected
        }
        
        return false;
    }
}
