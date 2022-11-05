// using prefix as variable
class Solution {
    public int subarraySum(int[] nums, int target) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1); // count of subarrays with prefix sum 0 is 1

        int prefix = 0;
        int subarrayCount = 0;
        for(int i = 0; i < nums.length; i++){
            prefix += nums[i];
            if(freq.containsKey(prefix - target)) subarrayCount += freq.get(prefix - target);
            freq.put(prefix, freq.getOrDefault(prefix, 0) + 1);
        }
        return subarrayCount;
    }
}

// using prefix[]
class Solution {
    public int subarraySum(int[] nums, int target) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1); // count of subarrays with prefix sum 0 is 1

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            prefix[i] = prefix[i - 1] + nums[i];

        int subarrayCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(freq.containsKey(prefix[i] - target)) subarrayCount += freq.get(prefix[i] - target);
            freq.put(prefix[i], freq.getOrDefault(prefix[i], 0) + 1);
        }
        return subarrayCount;
    }
}
