public int twoSum(int[] nums, int k){
  Arrays.sort(nums);
  int pairCount = 0;
  int lo = 0, hi = nums.length - 1;
  while(lo < hi){
    int sum = nums[lo] + nums[hi];
    if(sum <= k){
      pairCount += hi - lo;
      lo++;
    }
    else{
      hi--;
    }
  }
  return pairCount;
} 
