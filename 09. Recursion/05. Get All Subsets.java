// Time:O(2^N), SSpace:O(N)
class Solution {
    public List<List<Integer>> getSubsets(int[] nums, int idx){
        if(idx == nums.length){
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        // single call
        List<List<Integer>> res = getSubsets(nums, idx + 1);
        // post order
        List<List<Integer>> toAppend = new ArrayList<>();
        // deep copy
        for(List<Integer> subset : res){
            List<Integer> temp = new ArrayList<>();
            for(Integer i : subset)
                temp.add(i);
            toAppend.add(temp);
        }
        for(List<Integer> subset : toAppend)
            subset.add(nums[idx]);
        for(List<Integer> subset : toAppend)
            res.add(subset);
        
        return res;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        return getSubsets(nums, 0);
    }
}
