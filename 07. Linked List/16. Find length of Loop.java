class Solution
{
    static int countNodesinLoop(Node head)
    {
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                Node temp = head, temp2 = slow;
                while(temp != temp2){
                    temp = temp.next;
                    temp2 = temp2.next;
                }
                
                int count = 1;
                Node x = temp.next;
                while(x != temp){
                    count++;
                    x = x.next;
                }
                
                return count;
            }
        }
        
        return 0;
    }
}
