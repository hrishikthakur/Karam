class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> AB = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int product = nums[i] * nums[j];
                AB.put(product, AB.getOrDefault(product, 0) + 1);
            }
        }
        
        int ans = 0;
        for(int key : AB.keySet()){
            int n = AB.get(key);
            // n pairs me se selecting 2 pairs
            ans += (n * (n - 1)) / 2;
        }
        
        // how can pairs rearrange themselves
        return 8 * ans;
    }
}
