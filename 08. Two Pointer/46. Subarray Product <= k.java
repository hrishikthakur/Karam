// Time:O(2N), Space:O(1)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0) return 0;
        int left = 0, curr_product = 1, count_subs = 0;
        for(int right = 0; right < nums.length; right++){
            curr_product = curr_product * nums[right];
            while(left <= right && curr_product >= k){
                curr_product = curr_product / nums[left];
                left++;
            }
            count_subs += right - left + 1;
        }
        return count_subs;
    }
}
