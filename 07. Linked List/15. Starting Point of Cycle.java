// Meeting Point = Slow meets Fast
// Distance(Head, Starting Point) == Distance(Starting Point, Meeting Point)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        if(head.next == head) return head;
        
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                ListNode temp = head;
                while(temp != slow){
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        
        return null;
    }
}
