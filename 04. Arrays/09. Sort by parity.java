class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            if(nums[i] % 2 != 0){
                // odd - swop
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                j--;
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
