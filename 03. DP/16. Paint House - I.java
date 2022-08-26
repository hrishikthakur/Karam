// Memoization -> O(N * 3) = O(N) Time, O(N * 3) Space 
// Run Time Error due to Stack Overflow for N > 10^5
// Given test case -> 216831 which is > 10^5
public class Solution {
  
    public int minCost(int[][] costs, int houseIdx, int prevPaint, int[][] dp){
        if(houseIdx == costs.length) return 0;

        if(prevPaint != -1 && dp[houseIdx][prevPaint] != -1) return dp[houseIdx][prevPaint];

        int R = (prevPaint != 0) ? minCost(costs, houseIdx + 1, 0, dp) + costs[houseIdx][0] : Integer.MAX_VALUE;
        int B = (prevPaint != 1) ? minCost(costs, houseIdx + 1, 1, dp) + costs[houseIdx][1] : Integer.MAX_VALUE;
        int G = (prevPaint != 2) ? minCost(costs, houseIdx + 1, 2, dp) + costs[houseIdx][2] : Integer.MAX_VALUE;

        if(prevPaint == -1) return Math.min(R, Math.min(B, G));
        return dp[houseIdx][prevPaint] = Math.min(R, Math.min(B, G));
    }

    public int minCost(int[][] costs) {
        if(costs.length == 0) return 0;  
      
        int[][] dp = new int[costs.length][3];
        for(int i = 0; i < costs.length; i++){
            Arrays.fill(dp[i], -1);
        } 
        return minCost(costs, 0, -1 , dp);
    }
}

// Tabulation -> O(N * 3) = O(N) Time, O(N * 3) = O(N) Space
public class Solution {
    
    public int minCost(int[][] costs) {
      
        if(costs.length == 0) return 0;
        int n = costs.length;

        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i = 1; i < n; i++){
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}

// Space Optimization -> O(N * 3) = O(N) Time, O(1) Constant Extra Space
public class Solution {
    
    public int minCost(int[][] costs) {
        if(costs.length == 0) return 0;

        int prevR = costs[0][0];
        int prevB = costs[0][1];
        int prevG = costs[0][2];

        for(int i = 1; i < costs.length; i++){
            int currR = costs[i][0] + Math.min(prevB, prevG);
            int currB = costs[i][1] + Math.min(prevR, prevG);
            int currG = costs[i][2] + Math.min(prevR, prevB);

            prevR = currR;
            prevB = currB;
            prevG = currG;
        }

        return Math.min(prevR, Math.min(prevB, prevG));
    }
}
