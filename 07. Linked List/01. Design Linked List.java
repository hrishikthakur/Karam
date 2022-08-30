class MyLinkedList {
    
    Node head;
    int size;
    
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    public int get(int index) {
        if(size == 0 || index < 0 || index >= size) return -1;
        else{
            Node temp = head;
            for(int i = 0; i < index; i++)
                temp = temp.next;

            return temp.data;
        }
    }
    
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
        
        size++;
    }
    
    public void addAtTail(int val) {
        if(size == 0) addAtHead(val);
        else{
            Node newNode = new Node(val);
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = newNode;

            size++;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) return;
        else if(index == 0) addAtHead(val);
        else if(index == size) addAtTail(val);
        else{
            Node newNode = new Node(val);
            Node temp = head;
            for(int i = 0; i < index - 1; i++) // i - 1) cause pehle rukna hoga
                temp = temp.next;
            newNode.next = temp.next;
            temp.next = newNode;
            
            size++;
        }
    }
    
    public void removeFirst(){
        if(size == 0) return;
        else head = head.next;
        
        size--;
    }
    
    public void removeLast(){
        if(size == 0) return;
        else{
            Node temp = head;
            while(temp.next.next != null) 
                temp = temp.next;
            temp.next = null;
            
            size--;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(size == 0) return;
        else if(index < 0 || index >= size) return;
        else if(index == 0) removeFirst();
        else if(index == size - 1) removeLast(); 
        else{
            Node temp = head;
            for(int i = 0; i < index - 1; i++)
                temp= temp.next;
            temp.next = temp.next.next;
            
            size--;
        }
    }
}
