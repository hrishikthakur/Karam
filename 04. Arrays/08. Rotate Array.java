class Solution {
    
    public static void reverse(int[] a, int i, int j){
        int left = i;
        int right = j;
        while(left < right){
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            
            left++;
            right--;
        }
    }
    
    public void rotate(int[] nums, int k) {
        if(k > nums.length) k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
}
