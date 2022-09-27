// Two Pointer -> Time:O(NlogN + N), Space:O(1)
class Solution {
    public int findPairs(int[] nums, int target) {
        Arrays.sort(nums);
        
        int left = 0, right = 1;
        int diff_pair = 0;
        while(right < nums.length){
            if(left == right){
                right++;
                continue;
            }
            
            if(left > 0 && nums[left - 1] == nums[left]){
                left++;
                continue;
            }
            
            int diff = nums[right] - nums[left];
            if(diff == target){
                diff_pair++;
                left++;
            }else if(diff < target){
                right++;
            }else{
                left++;
            }
        }
        
        return diff_pair;
    }
}
