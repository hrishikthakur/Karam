// Two pointer -> Time:O(nlogn + n), Space:O(1)
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;
        while(i < j){
            if(nums[i] + nums[j] == k){
                count++;
                i++;
                j--;
            }else if(k < nums[i] + nums[j]){
                j--;
            }else{
                i++;
            }
        }
        
        return count;
    }
}
