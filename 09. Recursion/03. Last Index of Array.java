// Time:O(N), Stack Space:O(N)
public static int lastIndex(int[] arr, int idx, int x){
    if(idx == arr.length) return -1;
    int ans = lastIndex(arr, idx + 1, x);
    if(ans == -1){
        if(arr[idx] == x) return idx;
        else return -1;
    }else{
        return ans;
    }
}
