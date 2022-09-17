// Brute -> Using 2 pointer -> Time:O(n^2), Space:O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        
        return res;
    }
}

// 2 Traversal -> Using HashMap -> Time:O(2 * n), Space:O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            int remTarget = target - nums[i];
            if(map.containsKey(remTarget) == true && map.get(remTarget) != i){
                res[0] = i;
                res[1] = map.get(remTarget);
                return res;
            }
        }
        
        return res;
    }
}

// Single Traversal -> Using HashMap -> Time:O(n), Space:O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int remTarget = target - nums[i];
            if(map.containsKey(remTarget) == true){
                res[0] = map.get(remTarget);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        
        return res;
    }
}
