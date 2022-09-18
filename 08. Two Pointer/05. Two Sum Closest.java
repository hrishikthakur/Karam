// Lintcode - 533
public int twoSumClosest(int[] nums, int target){
  Arrays.sort(nums);
  int i = 0, right = nums.length - 1;
  int abs = Integer.MAX_VALUE;
  while(i < j){
    int sum = nums[i] + nums[j];
    if(sum == target){
      return 0;
    }else if(sum > target){
      abs = Math.min(abs, sum - target);
      j--;
    }else{
      abs = Math.min(abs, target - sum);
      i++;
    }
  }
  
  return abs;
}
