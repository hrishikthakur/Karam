// Time:O(N), Space:O(1)
class Complete{
    public static int minSwap (int arr[], int n, int k) {
        
        int win_size = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] <= k) win_size++;
        }
        
        int lesser_count = 0;
        for(int i = 0; i < win_size; i++){
            if(arr[i] <= k){
                lesser_count++;
            }
        }
        
        int min_swaps = win_size - lesser_count;
        for(int i = win_size; i < n; i++){
            // include
            if(arr[i] <= k) lesser_count++;
            // exclude
            if(arr[i - win_size] <= k) lesser_count--;
            min_swaps = Math.min(min_swaps, win_size - lesser_count);
        }
        
        return min_swaps;
    }
}
