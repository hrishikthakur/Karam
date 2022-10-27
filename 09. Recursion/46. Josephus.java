// LC -> Josephus Algo
class Solution {
    public int josephus(int n, int k){
        if(n == 1) return 0; // returning the 0th idx
        return (josephus(n - 1, k) + k) % n;
    }
    
    public int findTheWinner(int n, int k) {
        return josephus(n, k) + 1;
    }
}

// PEP -> Josephus Algo
public static int josephus(int n, int k){
    if(n == 1) return 0; // returning the 0th idx
    return (josephus(n - 1, k) + k) % n;
}


// Using Queue
class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= n; i++)
            q.add(i);
        
        while(q.size() > 1){
            for(int i = 1; i < k; i++){
                int top = q.remove();
                q.add(top);
            }
            q.remove();
        }
        return q.peek();
    }
}
