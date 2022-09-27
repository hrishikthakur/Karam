// Time:O(N), Space:O(N)
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] r_max = new int[n];
        r_max[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            r_max[i] = Math.max(nums[i], r_max[i + 1]);
        }
        
        int ans = 0;
        int i = 0, j = 0;
        while(i < n && j < n){
            if(nums[i] <= r_max[j]){
                ans = Math.max(ans, j - i);
                j++;
            }else i++;
        }
        
        return ans;
    }
}x
