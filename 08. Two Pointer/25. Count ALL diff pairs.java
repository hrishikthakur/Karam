// Only using HashMap -> Time:O(N), Space:O(N)
class Solution {
    public int countKDifference(int[] nums, int target) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        int pair_count = 0;
        for(Integer key : freq.keySet()){
            int freq_key = freq.get(key);
            int freq_comp = freq.getOrDefault(target + key, 0);
            pair_count += freq_key * freq_comp;
        }
        
        return pair_count;
    }
}
