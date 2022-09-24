// Time:O(N^2), Space:O(1)
class Solution { 
    public int twoSumGreater(int[] nums, int lo, int hi, int target){
        int count = 0;
        while(lo < hi){
            int sum = nums[lo] + nums[hi];
            if(sum > target){
                count += hi - lo;
                hi--;
            }else if(sum <= target){
                lo++;
            }
        }
        return count;
    }
    
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = nums.length - 1; i >= 2; i--){
            int target = nums[i];
            count += twoSumGreater(nums, 0, i - 1, target);
        }
        return count;
    }
}
