class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[lo] <= nums[mid]){
                // left is sorted
                if(target >= nums[lo] && target < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            }else{
                // right is sorted
                if(target >= nums[mid + 1] && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }
}

// O(logN)

// left <-- mid --> right
// either of the two will be sorted
// if(target is in the SORTED SIDE) reduce to this side (O(1))
// else shrink to the other part
// follow the same alog form the shortend array
// lastly nums[mid] will give the target element
