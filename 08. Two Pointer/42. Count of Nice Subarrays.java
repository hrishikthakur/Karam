// Time:O(2N + 2N), Space:O(1)
class Solution {
    
    public int atmostKodd(int[] nums, int k) {
        int count_odds = 0, count_subs = 0, left = 0;
        for(int right = 0; right < nums.length; right++){
            int inc = nums[right];
            if(inc % 2 == 1) count_odds++;
            
            while(count_odds > k){
                int exc = nums[left];
                if(exc % 2 == 1) count_odds--;
                left++;
            }
            count_subs += right - left + 1;
        }
        
        return count_subs;
    }
    
    public int numberOfSubarrays(int[] nums, int k) {
        return atmostKodd(nums, k) - atmostKodd(nums, k - 1);
    }
}
