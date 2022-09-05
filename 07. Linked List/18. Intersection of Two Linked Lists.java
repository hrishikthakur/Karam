// 1
public class Solution {
    
    public int getLength(ListNode head){
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        return len;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA), lenB = getLength(headB);
        
        if(lenA > lenB){
            for(int i = 0; i < lenA - lenB; i++)
                headA = headA.next;
        }else{
            for(int i = 0; i < lenB - lenA; i++)
                headB = headB.next;
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}

// 2
public class Solution {
    
    public ListNode detectCycle(ListNode head){
        if(head == null || head.next == null) return null;
        if(head.next == head) return head;
        
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                ListNode curr1 = head, curr2 = slow;
                while(curr1 != curr2){
                    curr1 = curr1.next;
                    curr2 = curr2.next;
                }
                return curr1;
            }
        }
        return null;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode tailB = headB;
        while(tailB.next != null)
            tailB = tailB.next;
        
        tailB.next = headB;
        
        ListNode ans = detectCycle(headA);
        tailB.next = null;
        return ans;
    }
}
