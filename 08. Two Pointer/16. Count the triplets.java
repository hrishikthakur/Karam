// Time:O(N^2), Space:O(1)
class Solution {  
    int twoSum(int[] arr, int lo, int hi, int target){
        int pair_count = 0;
        while(lo < hi){
            int sum = arr[lo] + arr[hi];
            if(sum == target){
                pair_count++;
                hi--;
                lo++;
            }else if(sum < target){
                lo++;
            }else{
                hi--;
            }
        }
        return pair_count;
    }
    
    int countTriplet(int arr[], int n) {
        Arrays.sort(arr);
        int triplet_count = 0;
        for(int i = arr.length - 1; i >= 2; i--){
            int target = arr[i];
            triplet_count += twoSum(arr, 0, i - 1, target);
        }
        return triplet_count;
    }
}
