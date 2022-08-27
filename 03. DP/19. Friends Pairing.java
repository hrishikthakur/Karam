// Time - O(N), Space - O(N) for Recursion Call Stack
class Solution
{
    public int mod = 1000000007;
    public long countFriendsPairings(int n, long[] dp){
        if(n == 0 || n == 1) return 1l;
        
        if(dp[n] != -1) return dp[n];
        
        long single = countFriendsPairings(n - 1, dp);
        long pair = (n - 1l) * countFriendsPairings(n - 2, dp);
        
        return dp[n] = (single + pair) % mod;
    }
    
    public long countFriendsPairings(int n) 
    { 
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        
        return countFriendsPairings(n, dp);
    }
}

// Space Optimization in Tabulation is Possible
// O(N) Time, O(1) Space
