// Time: O(n ^ 2), Space:O(n ^ 2)
class Solution {
    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i1 : a){
            for(int i2 : b){
                int key = i1 + i2;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        
        int count = 0;
        for(int i1 : c){
            for(int i2 : d){
                int target = -(i1 + i2); // because target = 0
                count += map.getOrDefault(target, 0);
            }
        }
        
        return count;
    }
}
