class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int low = 0; 
        int same = 0; // si for elements == pivot
        int high = 0; // si for elements > pivot
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot){
                low++; // found the count
            }else if(nums[i] == pivot){
                same++;
            }
        }
        high = low + same;
        same = low;
        low = 0;
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot){
                res[low] = nums[i];
                low++;
            }else if(nums[i] == pivot){
                res[same] = nums[i];
                same++;
            }else{
                res[high] = nums[i];
                high++;
            }
        }
        return res;
    }
}
