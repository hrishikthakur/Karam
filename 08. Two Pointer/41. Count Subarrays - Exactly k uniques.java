// Time:O(4N), Space:O(N)
class Solution {
    public int subarraysWithAtmostK(int[] nums, int k){
        HashMap<Integer, Integer> freq = new HashMap<>();
        int left = 0, count_subs = 0;
        for(int right = 0; right < nums.length; right++){
            int inc = nums[right];
            freq.put(inc, freq.getOrDefault(inc, 0) + 1);
            
            while(freq.size() > k){
                int exc = nums[left];
                if(freq.get(exc) == 1) freq.remove(exc);
                else freq.put(exc, freq.get(exc) - 1);
                left++;
            }
          x  count_subs += right - left + 1;
        }
        return count_subs;
    }
    
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtmostK(nums, k) - subarraysWithAtmostK(nums, k - 1);
    }
}
