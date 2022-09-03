class Solution
{
    public static Node reverse(Node head){
        if(head == null || head.next == null) return head;
        
        Node prev = null, curr = head, ahead = head.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = ahead;
            if(ahead != null) ahead = ahead.next;
        }
        
        return prev;
    }
    
    public static int length(Node head){
        Node temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
    
    public static boolean isGreater(Node l1, Node l2){
        if(length(l1) > length(l2)) return true;
        else if(length(l1) < length(l2)) return false;
        else {
            Node temp1 = l1, temp2 = l2;
            while(temp1 != null && temp2 != null){
                if(temp1.data < temp2.data) return false;
                if(temp1.data > temp2.data) return true;
                
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return false;
        }
    }
    
    static Node subLinkedList(Node l1, Node l2)
    {
        
        // remove starting 0s
        while(l1.data == 0 && l1.next != null)
            l1 = l1.next;
        while(l2.data == 0 && l2.next != null)
            l2 = l2.next;
        
      // if l2 > l1 swap
        if(isGreater(l1, l2) == false){
            // System.out.println("HGI");
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }
        
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        Node dummy = new Node(-1);
        Node tail = dummy;
        
        int borrow = 0;
        while(l1 != null){
            
            int diff = borrow + l1.data - ((l2 != null) ? l2.data : 0);
            if(diff < 0){
                borrow = -1;
                diff += 10;
            }else{
                borrow = 0;
            }
            
            Node node = new Node(diff);
            tail.next = node;
            tail = tail.next;
            
            l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        Node res = reverse(dummy.next);
        while(res.data == 0 && res.next != null)
            res = res.next;
        
        return res;
    }
}
