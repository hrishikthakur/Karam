// Time:O(N ^ 2), Space:O(1)
class Solution {
    
    public List<List<Integer>> twoSum(int[] nums, int lo, int hi, int target){
        List<List<Integer>> res = new ArrayList<>();
      
        int start = lo; // This
        while(lo < hi){
            if(lo > start && nums[lo - 1] == nums[lo]) {
                lo++;
                continue;
            }
            
            int sum = nums[lo] + nums[hi];
            if(sum == target){
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[lo]);
                pair.add(nums[hi]);
                res.add(pair);
                lo++;
                hi--;
            }else if(sum < target){
                lo++;
            }else{
                hi--;
            }
        }
        return res;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // This
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            
            List<List<Integer>> pairs = twoSum(nums, i + 1, nums.length - 1, -nums[i]);
            for(List<Integer> pair : pairs){
                pair.add(0, nums[i]); // This
                ans.add(pair);
            }
        }
        return ans;
    }
}
