// Time:O(n^2), Space:O(1)
class Solution {
    
    public int twoSumClosest(int[] nums, int lo, int hi, int target){
        int closest_sum = 0;
        int abs = Integer.MAX_VALUE;
        while(lo < hi){
            int sum = nums[lo] + nums[hi];
            if(sum == target){
                return sum;
            }else if(sum > target){
                if(sum - target < abs){
                    abs = sum - target;
                    closest_sum = sum;
                }
                hi--;
            }else{
                if(target - sum < abs){
                    abs = target - sum;
                    closest_sum = sum;
                }
                lo++;
            }
        }
        
        return closest_sum;
    }
    
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int abs = Integer.MAX_VALUE;
        int three_sum_closest = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int two_sum_closest = twoSumClosest(nums, i + 1, nums.length - 1, target - nums[i]); // silly
            int three_sum = nums[i] + two_sum_closest;
            if(Math.abs(target - three_sum) < abs){
                abs = Math.abs(target - three_sum);
                three_sum_closest = three_sum;
            }
        }
        return three_sum_closest;
    }
}
