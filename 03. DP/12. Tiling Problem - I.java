// Memoization -> O(n) time, O(n) Space
class Solution {
    
    static Long numberOfWays(int width, long[] dp){
        if(width == 1) return 1l;
        if(width == 2) return 2l;
        
        if(dp[width] != -1l) return dp[width];
        
        Long v = numberOfWays(width - 1, dp);
        Long h = numberOfWays(width - 2, dp);
        
        return dp[width] = (v + h) % 1000000007;
    }
    
    static Long numberOfWays(int N) {
        long[] dp = new long[N + 1];
        Arrays.fill(dp, -1);
        return numberOfWays(N, dp);
    }
};
