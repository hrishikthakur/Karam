emoization -> O(2*N) = O(N) Time, O(2*N) = O(N) Space
class Solution {
    
    int mod = 1000000007;
    long countStrings(int n, int prevDigit, long[][] dp){
        if(n == 0) return 1l;
        
        if(dp[prevDigit][n] != -1l) return dp[prevDigit][n];
        
        long append0 = countStrings(n - 1, 0, dp);
        long append1 = (prevDigit != 1) ? countStrings(n - 1, 1, dp) : 0l;
        
        return dp[prevDigit][n] = (append0 + append1) % mod;
    }
    
    long countStrings(int n) {
        long [][] dp = new long[2][n + 1];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        // begin with 0 so that both calls are made initially
        return countStrings(n, 0, dp);
    }
}

// Tabulation -> 
