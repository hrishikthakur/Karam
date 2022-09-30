// Time:O(2N), Space:O(1)
class Solution
{
    long findMaxSubarraySum(long arr[], int N,int X)
    {
        long max_sum = 0, curr_sum = 0;
        int left = 0;
        for(int right = 0; right < arr.length; right++){
            curr_sum += arr[right];
            while(curr_sum > X){
                curr_sum -= arr[left];
                left++;
            }
            max_sum = Math.max(max_sum, curr_sum);
        }
        return max_sum;
    }
}
