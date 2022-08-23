// Tabulation -> O(N^2) Time, O(N) Space

class Solution {
    public int minTaps(int n, int[] ranges) {
        
        // Creating Jumps Array by Making Interval's Left Value as Range Value
        int[] jumps = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            jumps[left] = Math.max(jumps[left], right - left);
        }
        
        // Now the problem is similar to Jump Game - II
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        for(int i = n - 1; i >= 0; i--){
            for(int jmp = 1; jmp <= jumps[i]; jmp++){
                dp[i] = (i + jmp <= n) ? Math.min(dp[i], dp[i + jmp] + 1l) : dp[i];
            }
        }
        return (dp[0] != Integer.MAX_VALUE) ? (int)dp[0] : -1;
    }
}
