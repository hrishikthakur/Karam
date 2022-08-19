// Recursion
class Solution {
    public static long jumper(int src, int dest, int[] nums){
        if(src == dest) return 0;
        long min = Integer.MAX_VALUE;
        for(int jmp = 1; jmp <= nums[src]; jmp++){
            if(src + jmp <= dest)
                min = Math.min(min, jumper(src + jmp, dest, nums) + 1l);
        }
        return min;
    }
    
    public int jump(int[] nums) {
        return (int)jumper(0, nums.length - 1, nums);
    }
}

// Memoization -> O(N * Jumps) = O(N ^ 2) Time, O(N) Space
public static long jumper(int src, int dest, int[] nums,  long[] dp){
    if(src == dest) return 0;
    long min = Integer.MAX_VALUE;
    if(dp[src] != -1) return dp[src];
    for(int jmp = 1; jmp <= nums[src]; jmp++){
        if(src + jmp <= dest)
            min = Math.min(min, jumper(src + jmp, dest, nums, dp) + 1l);
    }
    dp[src] = min;
    return min;
}

// Tabulation -> O(N) Time and O(N) Space
class Solution {
public int jump(int[] nums) {
      int n = nums.length;
      int[] dp = new int[n];
      dp[n - 1] = 0;
      for(int i = n - 2; i >= 0; i--){
        int ans = Integer.MAX_VALUE;
        for(int jmp = 1; jmp <= nums[i]; jmp++){
          if(i + jmp < n && dp[i + jmp] != Integer.MAX_VALUE){
            ans = Math.min(ans, dp[i + jmp] + 1);
          }
        }
        dp[i] = ans;
      }
      return dp[0];
    }
}
