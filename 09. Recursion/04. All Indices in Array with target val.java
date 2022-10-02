// Time:O(N), Space:O(N)
public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
    if(idx == arr.length){
        return new int[fsf];
    }
    // if(arr[idx] == x) fsf++;
    if(arr[idx] == x){
        int[] res = allIndices(arr, x, idx + 1, fsf + 1);
        res[fsf] = idx;
        return res;
    }else{
        int[] res = allIndices(arr, x, idx + 1, fsf);
        return res;
    }

}
