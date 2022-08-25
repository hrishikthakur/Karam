// Memoization -> Time - O(N * 2) = O(N), Space - O(N * 2) = O(N)
class Solution {
    
    public int rob(int[] nums, int idx, int prevState, int[][] dp){
        if(idx == nums.length) return 0;
        
        if(dp[prevState][idx] != -1) return dp[prevState][idx];
        
        int yes = (prevState == 0) ? rob(nums,idx + 1, 1, dp) + nums[idx]: 0;
        int no = rob(nums, idx + 1, 0, dp);
        
        
        return dp[prevState][idx] = Math.max(yes, no);
    }
    
    public int rob(int[] nums) {
        int[][] dp = new int[2][nums.length + 1];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return rob(nums, 0, 0, dp);
    }
}

// Tabulation
