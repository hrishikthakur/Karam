public class Solution {
    public int solve(int[] arr, int target) {
        int n = arr.length;
        if(n < 2) return 0;
        
        Arrays.sort(arr);
        int left = 0, right = 1;
        while(left < n && right < n){
            if(left == right){
                if(target < 0) left++;
                else right++;
                continue;
            }
            
            int diff = arr[right] - arr[left];
            if(diff == target) return 1;
            else if(diff < target){
                right++;
            }else{
                left++;
            }
        }
        
        return 0;
    }
}
