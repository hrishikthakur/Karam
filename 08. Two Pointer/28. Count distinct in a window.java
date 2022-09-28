// Time:O(N), Space:O(N)
public class Solution {
    public int[] dNums(int[] A, int B) {
        int N = A.length;
        HashMap<Integer, Integer> distinct = new HashMap<>();
        
        int idx = 0;
        int[] res = new int[N - B + 1];
        for(int i = 0; i < B; i++){
            distinct.put(A[i], distinct.getOrDefault(A[i], 0) + 1);
        }
        res[idx++] = distinct.size();
        
        for(int i = B; i < N; i++){
            int ex_freq = distinct.get(A[i - B]);
            if(ex_freq == 1) distinct.remove(A[i - B]);
            else distinct.put(A[i - B], distinct.get(A[i - B]) - 1);
            
            distinct.put(A[i], distinct.getOrDefault(A[i], 0) + 1);
            res[idx++] = distinct.size();
        }
        
        return res;
    }
}
