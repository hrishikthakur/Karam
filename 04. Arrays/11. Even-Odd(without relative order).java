class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0; // 1st unvisited
        int j = 0; // 1st odd
        while(i < nums.length){
            if(nums[i] % 2 == 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                i++;
                j++;
            }else{
                i++;
            }
        }
        int[] res = new int[nums.length];
        for(int k = 0; k < nums.length; k++){
            res[k] = nums[k];
        }
        return res;
    }
}
