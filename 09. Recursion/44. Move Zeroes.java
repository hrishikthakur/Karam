public static void moveZeroes(int idx, int countOfNonZero, int[] nums) {
     if(idx == nums.length){
         int countOfZero = nums.length - countOfNonZero;
         for(int i = 0; i < countOfZero; i++){
             nums[idx - 1 - i] = 0;
         }
         return;
     }

     if(nums[idx] != 0){
         nums[countOfNonZero] = nums[idx];
         moveZeroes(idx + 1, countOfNonZero + 1, nums);
     }
     else{
         moveZeroes(idx + 1, countOfNonZero, nums);
     }
 }
