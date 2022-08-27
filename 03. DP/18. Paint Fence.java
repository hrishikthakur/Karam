//  Memoization -> Time - O(N), Space - O(2 * N) = O(N)
public class Solution {
    
    public int numWays(int n, int k, int[] dp){
        if(n == 1) return k;
        if(n == 2) return k * k;

        if(dp[n] != -1) return dp[n];

        int ans = (numWays(n - 2, k, dp) + numWays(n - 1, k, dp)) * (k - 1);
        
        return dp[n] = ans;
    }

    public int numWays(int n, int k) {
        if(n == 1) return k;
        if(n == 2) return k * k;
        if(k == 1) return 0;

        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        return numWays(n, k, dp);
    }
}

// Tabulation -> Time - O(N), Space - O(2 * N) = O(N)
public class Solution {
    
    public int numWays(int n, int k) {
        if(n == 1) return k;
        if(n == 2) return k * k;
        if(k == 1) return 0;

        int[] ii = new int[n + 1];
        int[] ij = new int[n + 1];

        ii[2] = k;
        ij[2] = k * (k - 1);
        for(int i = 3; i <= n; i++){
            ii[i] = ij[i - 1];
            ij[i] = (ii[i - 1] + ij[i - 1]) * (k - 1); 
        }

        return ii[n] + ij[n];
    }
}

// Space Optimization in tabulation -> Time - O(N), Space - O(1)
public class Solution {

    public int numWays(int n, int k) {
        if(n == 1) return k;
        if(n == 2) return k * k;
        if(k == 1) return 0;

        int ii = k;
        int ij = k * (k - 1);
        int total = ii + ij;

        for(int i = 3; i <= n; i++){
            ii = ij;
            ij = total * (k - 1);
            total = ii + ij;
        }

        return total;
    }
}
