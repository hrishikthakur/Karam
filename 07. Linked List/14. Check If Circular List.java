class GfG
{
    boolean isCircular(Node head)
    {
        if(head == null || head.next == null) return false;
        if(head.next == head) return true;
        
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow){
                return (fast == head) ? true : false;
            }
        }
        
        return false;
    }
}
