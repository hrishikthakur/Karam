// Fix first element
// Apply twoSum on the rest of the array
public class Solution {

    public int twoSum(int nums[], int lo, int hi, int target){
        int pair_count = 0;
        while(lo < hi){
            int sum = nums[lo] + nums[hi];
            if(sum < target){
                pair_count += hi - lo;
                lo++;
            }else {
                hi--;
            }
        }

        return pair_count;
    }
    
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int pair_count = 0;
        for(int i = 0; i < nums.length; i++){
            pair_count += twoSum(nums, i + 1, nums.length - 1, target - nums[i]);
        }
        return pair_count;
    }
}
