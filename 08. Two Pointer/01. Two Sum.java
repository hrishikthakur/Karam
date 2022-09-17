// Brute -> Time:O(n^2), Space:O(1)
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

// 2 Traversal using HashMaps -> Time:O(2 * n), Space:O(n)

// Single Traversal using HashMap -> Time:O(n), Space:O(n)
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
