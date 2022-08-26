// Memoization - Time O(N * K * K) (Cubic), Space -> O(N * K) (Matrix + Recursion Stack)
// Runtime Error -> Stack Overflow -> N > 10^5
public class Solution {

    public int paintHouse(int[][] costs, int houseIdx, int prevPaint, int[][] dp){
        int k = costs[0].length;
        if(houseIdx == costs.length) return 0;

        if(prevPaint != -1 && dp[houseIdx][prevPaint] != -1) return dp[houseIdx][prevPaint];

        int cost = Integer.MAX_VALUE;
        for(int paint = 0; paint < k; paint++){
            int currCost = Integer.MAX_VALUE;
            if(paint != prevPaint){
                currCost = costs[houseIdx][paint] + paintHouse(costs, houseIdx + 1, paint, dp);
            }
            cost = Math.min(cost, currCost);
        }

        if(prevPaint == -1) return cost;
        return dp[houseIdx][prevPaint] = cost;
    }

    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;

        int n = costs.length;
        int k = costs[0].length;

        int[][] dp = new int[n][k];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        
        return paintHouse(costs, 0, -1, dp);
    }
}

// Tabulation -> Time O(N * K * K) (Cubic), Space -> O(N * K) (Matrix)
public class Solution {
    
    public int minPrevRow(int[][] dp, int row, int currPaint){
        int k = dp[0].length;
        int min = Integer.MAX_VALUE;
        for(int paint = 0; paint < k; paint++){
            if(paint != currPaint) min = Math.min(min, dp[row][paint]);
        }
        return min;
    }

    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;

        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        for(int paint = 0; paint < k; paint++)
            dp[0][paint] = costs[0][paint];

        for(int house = 1; house < n; house++){
            for(int paint = 0; paint < k; paint++){
                dp[house][paint] = costs[house][paint] + minPrevRow(dp, house - 1, paint);
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int paint = 0; paint < k; paint++)
            ans = Math.min(ans, dp[n - 1][paint]);

        return ans;
    }
}

// Time Optimization
// Time -> O(N * K) (Quadratic), Space -> O(N * K) (Matrix)
public class Solution {

    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;

        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        for(int paint = 0; paint < k; paint++)
            dp[0][paint] = costs[0][paint];

        for(int house = 1; house < n; house++){

            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for(int paint = 0; paint < k; paint++){
                if(dp[house - 1][paint] <= min1){
                    min2 = min1;
                    min1 = dp[house - 1][paint];
                }else if(dp[house - 1][paint] < min2){
                    min2 = dp[house - 1][paint];
                }
            }

            for(int paint = 0; paint < k; paint++){
                if(dp[house - 1][paint] != min1) dp[house][paint] = costs[house][paint] + min1;
                else dp[house][paint] = costs[house][paint] + min2;
                
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int paint = 0; paint < k; paint++)
            ans = Math.min(ans, dp[n - 1][paint]);

        return ans;
    }
}

// Space Optimization: Time -> O(N * K) (Quadratic),
// Space -> O(K) (Linear Array)
public class Solution {

    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;

        int n = costs.length;
        int k = costs[0].length;
        int[] dp = new int[k];
        for(int paint = 0; paint < k; paint++)
            dp[paint] = costs[0][paint];

        for(int house = 1; house < n; house++){

            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for(int paint = 0; paint < k; paint++){
                if(dp[paint] <= min1){
                    min2 = min1;
                    min1 = dp[paint];
                }else if(dp[paint] < min2){
                    min2 = dp[paint];
                }
            }

            int[] curr = new int[k];
            for(int paint = 0; paint < k; paint++){
                if(dp[paint] != min1) curr[paint] = costs[house][paint] + min1;
                else curr[paint] = costs[house][paint] + min2;
            }
            dp = curr;
        }

        int ans = Integer.MAX_VALUE;
        for(int paint = 0; paint < k; paint++)
            ans = Math.min(ans, dp[paint]);

        return ans;
    }
}
