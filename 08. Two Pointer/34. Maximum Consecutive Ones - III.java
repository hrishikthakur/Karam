// Time:O(2N), Space:O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int max_len = 0, count_zeros = 0, left = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0) count_zeros++;
            while(count_zeros > k){
                if(nums[left] == 0) count_zeros--;
                left++;
            }
            max_len = Math.max(max_len, right - left + 1);
        }
        return max_len;
    }
}
