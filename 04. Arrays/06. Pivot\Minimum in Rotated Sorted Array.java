class Solution {
    
    public int findMin(int[] nums) {
        // minimum element is the only element whose previous is greater than it
        
        int lo = 0, hi = nums.length - 1;
        
        // for while think of case : array is of length 1
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] < nums[hi]){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        
        return nums[lo];
    }
}
