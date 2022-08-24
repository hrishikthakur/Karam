// Memoization -> O(n) Time, O(n) Space
class Solution
{
    
    public int countWays(int n, int m, int[] dp){
        if(n < m) return 1;
        if(n == m) return 2;
        
        if(dp[n] != -1) return dp[n];
        
        int h = countWays(n - 1, m, dp);
        int v = countWays(n - m, m, dp);
        
        return dp[n] = (h + v) % 1000000007;
    }
    
    public int countWays(int n, int m)
    {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return countWays(n, m, dp);
    }
}

// Tabulation (with Sliding Window Space Optimization)
// O(N) Time, O(M) Space
// Note: Space cannot be Constant or O(1),
// i.e. Two Pointers Technique is not possible
