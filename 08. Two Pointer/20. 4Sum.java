// Loop + Loop + 2 Pointer -> Time:O(N^3), Space:O(1)
class Solution {
    public static List<List<Integer>> twoSumUnique(int[] nums, int lo, int hi, long target){
        List<List<Integer>> pairs = new ArrayList<>();
        int start = lo;
        while(lo < hi){
            if(lo > start && nums[lo - 1] == nums[lo]){
                lo++;
                continue;
            }
            
            long sum = nums[lo] + nums[hi];
            if(sum == target){
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[lo]);
                pair.add(nums[hi]);
                pairs.add(pair);
                lo++;
                hi--;
            }else if(sum < target){
                lo++;
            }else{
                hi--;
            }
        }
        return pairs;
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            long t1 = target - nums[i];
            
            for(int j = i + 1; j < nums.length; j++){
                if(j > i + 1 && nums[j - 1] == nums[j]) continue;
                long t2 = t1 - nums[j];
                List<List<Integer>> pairs = twoSumUnique(nums, j + 1, nums.length - 1, t2);
                for(List pair : pairs){
                    pair.add(0, nums[i]);
                    pair.add(1, nums[j]);
                    res.add(pair);
                }
            }
        }
        
        return res;
    }
}

// Using kSum -> Time:O(N ^ k - 1), Space:O(1)
class Solution {
    
    public List<List<Integer>> twoSum(int[] nums, int lo, int hi, long target){
        List<List<Integer>> pairs = new ArrayList<>();
        int start = lo;
        while(lo < hi){
            if(lo > start && nums[lo - 1] == nums[lo]){
                lo++;
                continue;
            }
            long sum = nums[lo] + nums[hi];
            if(sum == target){
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[lo]);
                pair.add(nums[hi]);
                pairs.add(pair);
                lo++;
                hi--;
            }else if(sum < target){
                lo++;
            }else{
                hi--;
            }
        }
        return pairs;
    }
    
    public List<List<Integer>> kSum(int[] nums, int start, int k, long target){
        if(k == 2){
            return twoSum(nums, start, nums.length - 1, target);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i - 1] == nums[i]){
                continue;
            }
            
            List<List<Integer>> pairs = kSum(nums, i + 1, k - 1, target - nums[i]);
            for(List pair : pairs){
                pair.add(0, nums[i]);
                res.add(pair);
            }
        }
        return res;
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }
}

// Using HashMap -> Time:O(N ^ 4), Space:O(N ^ 2)
// Gives TLE
class Solution {
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        HashMap<Integer, List<int[]>> AB = new HashMap<>();
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                int[] idx_pair = new int[2];
                idx_pair[0] = i;
                idx_pair[1] = j;
                
                if(AB.containsKey(sum) == false){
                    List<int[]> temp = new ArrayList<>();
                    AB.put(sum, temp);
                }
                AB.get(sum).add(idx_pair);
            }
        }
        
        HashSet<List<Integer>> uniques = new HashSet<>();
        for(int p = 0; p < nums.length; p++){
            for(int q = p + 1; q < nums.length; q++){
                int rem_target = target - nums[p] - nums[q];
                if(AB.containsKey(rem_target)){
                    for(int[] idx_pair : AB.get(rem_target)){
                        if(p != idx_pair[0] && p != idx_pair[1] && q != idx_pair[0] && q != idx_pair[1]){
                            List<Integer> quad = new ArrayList<>();
                            quad.add(nums[idx_pair[0]]);
                            quad.add(nums[idx_pair[1]]);
                            quad.add(nums[p]);
                            quad.add(nums[q]);
                            Collections.sort(quad);
                            uniques.add(quad);
                        }
                    }
                }
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> quad : uniques){
            res.add(quad);
        }
        return res;
    }
}
