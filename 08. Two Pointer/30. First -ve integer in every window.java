// Time:O(N), Space:O(K)
class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        
        Deque<Long> q = new ArrayDeque<>();
        for(int i = 0; i < K; i++){
            if(A[i] < 0) q.addLast(A[i]);
        }
        
        long[] res = new long[N - K + 1];
        int idx = 0;
        // manage the first window
        res[idx++] = (q.size() == 0) ? 0 : q.getFirst();
        
        for(int i = K; i < N; i++){
            // remove
            if(q.size() > 0 && A[i - K] < 0){
                q.removeFirst();
            }
            
            // add
            if(A[i] < 0){
                q.addLast(A[i]);
            }
            
            res[idx++] = (q.size() == 0) ? 0 : q.getFirst();
        }
        
        return res;
    }
}

// adding indices to queue
class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        
        Deque<Long> q = new ArrayDeque<>();
        for(int i = 0; i < K; i++){
            if(A[i] < 0) q.addLast(i);
        }
        
        long[] res = new long[N - K + 1];
        int idx = 0;
        res[idx++] = (q.size() == 0) ? 0 : q.getFirst();
        
        for(int i = K; i < N; i++){
            if(q.size() > 0 && q.getFirst() <= i - K){
                q.removeFirst();
            }
            
            if(A[i] < 0){
                q.addLast(i);
            }
            
            res[idx++] = (q.size() == 0) ? 0 : q.getFirst();
        }
        
        return res;
    }
}
