class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int max_size = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) continue;
            int curr_size = 0;
            while(i < nums.length && nums[i] == 1){
                curr_size++;
                i++;
            }
            max_size = Math.max(max_size, curr_size);
        }
        
        return max_size;
    }
}
