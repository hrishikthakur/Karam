// Memoization -> O(2 * (2 * N)) = O(N), Space - O(2 * (2 * N)) = O(N)
class Solution {
    
    public int rob(int[] nums, int idx, int prevState, int[][] dp){
        if(idx == nums.length) return 0;
        
        if(dp[prevState][idx] != -1) return dp[prevState][idx];
        
        int yes = (prevState == 0) ? rob(nums,idx + 1, 1, dp) + nums[idx]: 0;
        int no = rob(nums, idx + 1, 0, dp);
        
        
        return dp[prevState][idx] = Math.max(yes, no);
    }
    
    public int helper(int[] nums){
        int n = nums.length;
        int[][] dp = new int[2][n + 1];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return rob(nums, 0, 0, dp);
    }
    
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int ans1 = helper(Arrays.copyOfRange(nums, 0, n - 1));
        int ans2 = helper(Arrays.copyOfRange(nums, 1, n));
        return Math.max(ans1, ans2);
    }
}
