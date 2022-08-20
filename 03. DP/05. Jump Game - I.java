// Memoization
public int jumper(int src, int[] nums, int[] dp){
    if(src == nums.length - 1) return 1;
    if(dp[src] != -1) return dp[src];
    int res = 0;
    // agar nums[i] == 0, loop kabhi chalegi nhi, res = 0
    for(int jmp = 1; jmp <= nums[src]; jmp++){
        if(src + jmp < nums.length)
        res = jumper(src + jmp, nums, dp);
        System.out.println("HI" + res);
        // if(res == 1) return 1;
    }
    dp[src] = res;
    return res;
}

// Greedy -> O(N) Time, O(1) Space
class Solution {
    public boolean canJump(int[] jumps) {
        int reach = 0;
        for(int i = 0; i < jumps.length; i++){
            if(i > reach) return false;
            if(i + jumps[i] > reach) reach = i + jumps[i];
        }
        return true;
    }
}


// Top Down Dynamic Programming (Memoization)
// Time = O(N * Jumps) -> O(10^4 * 10^5) which is > 10^8(allowed operations) ... hence O(N ^ 2) -> Time Limit Exceeded
// Space -> O(N)
class DP {
    public long memo(int src, int[] jumps, long[] dp) {
        if (src == jumps.length - 1)
            return 0; // min moves to go to dest from dest is 0 (empty string)
        if (dp[src] != -1)
            return dp[src];

        long min = Integer.MAX_VALUE;
        for (int jump = 1; jump <= jumps[src]; jump++) {
            if (src + jump < jumps.length) {
                min = Math.min(min, memo(src + jump, jumps, dp) + 1l);
            }
        }

        dp[src] = min;
        return min;
    }

    public boolean canJump(int[] jumps) {
        long[] dp = new long[jumps.length + 1];
        Arrays.fill(dp, -1);

        return ((int) memo(0, jumps, dp) == Integer.MAX_VALUE)
                ? false
                : true;
    }
}
