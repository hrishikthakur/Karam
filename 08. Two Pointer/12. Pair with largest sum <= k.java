class Solution {
    static ArrayList<Integer> Max_Sum(int[] arr, int n, int k) {
        
        Arrays.sort(arr);
        int abs = Integer.MAX_VALUE;
        int[] res = new int[2];
        int lo = 0, hi = n - 1;
        while(lo < hi){
            int sum = arr[lo] + arr[hi];
            if(sum >= k){
                hi--;
            }else if(sum < k){
                if(k - sum < abs){
                    res[0] = arr[lo];
                    res[1] = arr[hi];
                    abs = k - sum;
                }
                lo++;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(res[0]);
        ans.add(res[1]);
        return ans;
    }
}
