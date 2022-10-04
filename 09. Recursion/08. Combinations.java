// Time:O(2^N)
// Box on level
class Solution {
    public void combine(List<List<Integer>> combinations, List<Integer> curr_combination,
                       int curr_box, int n, int k){
        if(curr_box == n){
            if(curr_combination.size() == k){
                List<Integer> temp = new ArrayList<>(curr_combination);
                combinations.add(temp);
            }
            return;
        }
        // yes
        curr_combination.add(curr_box + 1);
        combine(combinations, curr_combination, curr_box + 1, n, k);
        curr_combination.remove(curr_combination.size() - 1);
        // no
        combine(combinations, curr_combination, curr_box + 1, n, k);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> curr_combination = new ArrayList<>();
        combine(combinations, curr_combination, 0, n, k);
        return combinations;
    }
}
