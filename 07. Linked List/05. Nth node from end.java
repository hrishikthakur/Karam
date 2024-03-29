// Brute -> Two traversal approach
class GfG
{
    int getLength(Node head){
        if(head == null) return 0;
        int len = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        return len;
    }
    
    int getNthFromLast(Node head, int n)
    {
    	int len = getLength(head);
    	int targetIdx = len - n;
    	if(targetIdx < 0) return -1;
    	Node temp = head;
    	for(int i = 0; i < targetIdx; i++){
    	    temp = temp.next;
    	}
    	
    	return temp.data;
    }
}

// Hare and Tortoise
class GfG
{
   
    int getNthFromLast(Node head, int n)
    {
        Node slow = head;
        Node fast = head;
        
        while(fast != null && n-- > 0)
            fast = fast.next;

        if(n > 0) return -1;
        
        while(fast != null){
             slow = slow.next;
             fast = fast.next;
        }

        return slow.data;
    }
}
