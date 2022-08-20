// Memoization -> O(N) Time, O(N) Space
class Solution {
    
    public int findMinCost(int src, int[] cost, int[] dp){
        
        if(src >= cost.length) return 0;
        if(dp[src] != -1) return dp[src];
        
        int cost1 = findMinCost(src + 1, cost, dp);
        int cost2 = findMinCost(src + 2, cost, dp);
        
        dp[src] = Math.min(cost1, cost2) + cost[src];
        return dp[src];
    }
    
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        
        findMinCost(0, cost, dp);
        return Math.min(dp[0], dp[1]);
    }
}

// Tabulation -> O(N) Time, O(N) Space
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length + 1;
        int[] dp = new int[n];
        dp[n - 1] = 0;
        dp[n - 2] = cost[n - 2];
        for(int i = n - 3; i >= 0; i--){
            dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
        }
        
        return Math.min(dp[0], dp[1]);
    }
}
