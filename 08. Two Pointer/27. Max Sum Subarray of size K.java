// Time:O(N), Space:O(1)
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        long curr_sum = 0;
        for(int i = 0; i < K; i++){
            curr_sum += Arr.get(i);
        }
        
        long max_sum = curr_sum;
        for(int i = K; i < N; i++){
            curr_sum = curr_sum - Arr.get(i - K) + Arr.get(i);
            max_sum = Math.max(max_sum, curr_sum);
        }
        
        return max_sum;
    }
}
