// Recursion -> O(3^N) Time, O(N) Space

// Memoization -> O(N) Time, O(N) Space
public static int climbStairs(int n, int[] dp){
    if(n == 0) return 1;
    if(dp[n] != -1) return dp[n];
    int x = (n - 1 >= 0) ? climbStairs(n - 1, dp) : 0;
    int y = (n - 2 >= 0) ? climbStairs(n - 2, dp) : 0;
    int z = (n - 3 >= 0) ? climbStairs(n - 3, dp) : 0;
    dp[n] = x + y + z;
    return dp[n];
}

// Tabulation -> O(N) Time, O(N) Space
public static int climbStairs(int n){
  int[] dp = new int[n + 1];
  dp[0] = 1;
  for(int i = 1; i <= n; i++){
      int x = (i - 1 >= 0) ? dp[i - 1] : 0;
      int y = (i - 2 >= 0) ? dp[i - 2] : 0;
      int z = (i - 3 >= 0) ? dp[i - 3] : 0;
      dp[i] = x + y + z;
  }
  return dp[n];
}

// Space Optimization (Using 4 Pointer technique) -> O(N) Time, O(1) Space
public static int climbStairs(int n){
  int prev1 = 1, prev2 = 0, prev3 = 0;
  for(int i = 1; i <= n; i++){
      int curr = prev1 + prev2 + prev3;
      prev3 = prev2;
      prev2 = prev1;
      prev1 = curr;
  }
  return prev1;
}
