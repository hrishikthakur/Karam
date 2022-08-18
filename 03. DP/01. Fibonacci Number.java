// Recursion => 2^N

// Memoization
class Solution {
  
    public int fibHelper(int n, int[] dp){
      if(n <= 1) return n;
      
      if(dp[n] != -1) return dp[n];
      int fibnm1 = fibHelper(n - 1, dp);
      int fibnm2 = fibHelper(n - 2, dp);
      dp[n] = fibnm1 + fibnm2;
      return dp[n];
    }
  
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fibHelper(n, dp);
    }
}

// Tabulation
class Solution {
    public int fib(int n) {
      if(n <= 1) return n;
      int[] dp = new int[n + 1];
      dp[0] = 0;
      dp[1] = 1;
      for(int i = 2; i <= n; i++)
        dp[i] = dp[i - 1] + dp[i - 2];
      return dp[n];
    }
}

// Space Optimization
class Solution {
    public int fib(int n) {
      if(n <= 1) return n;
      int prev1 = 0;
      int prev2 = 1;
      for(int i = 2; i <= n; i++){
        int curr = prev1 + prev2;
        prev1 = prev2;
        prev2 = curr;
      }
      return prev2; 
    }
}
