// Time:O(n + m + l), Space:O(1)
public class Solution {
    public int minimize(final int[] A, final int[] B, final int[] C) {
        int i = 0, j = 0, k = 0;
        int ans = Integer.MAX_VALUE;
        while(i < A.length && j < B.length && k < C.length){
            int a = Math.abs(A[i] - B[j]);
            int b = Math.abs(B[j] - C[k]);
            int c = Math.abs(C[k] - A[i]);
            
            int max = Math.max(a, Math.max(b, c));
            ans = Math.min(ans, max);
            
            if(A[i] <= B[j] && A[i] <= C[k]) i++;
            else if(B[j] <= A[i] && B[j] <= C[k]) j++;
            else k++;
        }
        return ans;
    }
}
