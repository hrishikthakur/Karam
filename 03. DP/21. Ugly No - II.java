// Using Priority Queue -> O(N * Log N) Time, O(N) Space for Priority Queue + Visited HashSet
class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        
        PriorityQueue<Long> q = new PriorityQueue<>();
        q.add(1l);
        
        HashSet<Long> vis = new HashSet<>();
        int idx = 0;
        while(q.size() > 0){
            long min = q.remove();
            if(vis.contains(min) == true) continue;
            vis.add(min);
            
            idx++;
            if(idx == n) return (int)min;
            
            q.add(min * 2l);
            q.add(min * 3l);
            q.add(min * 5l);
        }
        
        return 1;
    }
}

// Using 3 Pointer Technique
class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        
        // Pointers Pointing to Indices(ith ugly no.) not Values
        int ptr2 = 1, ptr3 = 1, ptr5 = 1;
        // ptr2 points to that ugly no. which is formed by mutiplying previous ugly no. by 2
        // ptr3 points to that ugly no. which is formed by mutiplying previous ugly no. by 3
        
        ArrayList<Integer> ugly = new ArrayList<>();
        ugly.add(-1); // 0th ugly no. is -1
        ugly.add(1); // 1st ugly no. is 1
        
        for(int i = 2; i <= n; i++){
            int a = ugly.get(ptr2) * 2;
            int b = ugly.get(ptr3) * 3;
            int c = ugly.get(ptr5) * 5;
            
            int min = Math.min(a, Math.min(b, c));
            ugly.add(min);
            
            if(min == a) ptr2++;
            if(min == b) ptr3++;
            if(min == c) ptr5++;
        }
        
        return ugly.get(n);
    }
}
