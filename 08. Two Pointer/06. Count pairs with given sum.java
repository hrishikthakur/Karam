// Using HashMap -> Time:O(n), Space:O(n)
class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            int complement = k - arr[i];
            int freq = map.getOrDefault(complement, 0);
            ans += freq;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        return ans;
    }
}
