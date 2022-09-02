// Brute Force -> Time: O(N * K) or O(n * K * k)
// N is the length of resultant list
// n is avg no. of nodes in 1 list
class Solution {
    
    public int minimum(ListNode[] lists){
        int min = Integer.MAX_VALUE;
        int idx = -1;
        
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null && lists[i].val < min){
                min = lists[i].val;
                idx = i;
            }
        }
        return idx;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 ) return null;
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy, tail = dummy;
        
        while(true){
            int minIdx = minimum(lists);
            if(minIdx == -1) break;
            
            tail.next = lists[minIdx];
            lists[minIdx] = lists[minIdx].next;
            tail = tail.next;
        }
        
        return dummy.next;
    }
}

// Divide & Conquer -> Time: O(k * n * logk)
// n is avg no. of nodes in 1 list
class Solution {
    
    public ListNode mergeTwoLists(ListNode head1, ListNode head2){
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy, tail = dummy;
        
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        
        tail.next = (head1 == null) ? head2 : head1;
        return dummy.next;
    }
    
    public ListNode helper(ListNode[] lists, int si, int ei){
        if(si == ei) return lists[si];
        
        int mid = (si + ei) / 2;
        ListNode l1 = helper(lists, si, mid);
        ListNode l2 = helper(lists, mid + 1, ei);
        
        return mergeTwoLists(l1, l2);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return helper(lists, 0, lists.length - 1);
    }
}
