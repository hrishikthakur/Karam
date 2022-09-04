class Solution
{
    public static void removeLoop(Node head){
        if(head == null || head.next == null) return;
        if(head.next == head){
            head.next = null;
            return;
        }
        
        Node slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                Node curr1 = head, curr2 = slow;
                while(curr1 != curr2){
                    prev = curr2;
                    curr1 = curr1.next;
                    curr2 = curr2.next;
                }
                prev.next = null;
                return;
            }
        }
        return;
    }
}
