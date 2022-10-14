// Unique Item on level
// Current level par hi current item ko nipta denge

class Solution {
    public static void subsets(int currItem, List<List<Integer>> res, List<Integer> subset,
                               ArrayList<Integer> uniques, HashMap<Integer, Integer> freq){
        if(currItem == uniques.size()){
            res.add(new ArrayList<>(subset));
            return;
        }
        
        subsets(currItem + 1, res, subset, uniques, freq); // no (why first -> See the req output)
        for(int i = 0; i < freq.get(uniques.get(currItem)); i++){
            // add karo ... call karo
            subset.add(uniques.get(currItem));
            subsets(currItem + 1, res, subset, uniques, freq);
        }
        
        // remove from subset after node post (not edge post)
        for(int i = 0; i < freq.get(uniques.get(currItem)); i++){
            subset.remove(subset.size() - 1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> uniques = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(freq.containsKey(nums[i]) == false){
                uniques.add(nums[i]);
                freq.put(nums[i], 1);
            }else{
                freq.put(nums[i], freq.get(nums[i]) + 1);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        subsets(0, res, new ArrayList<>(), uniques, freq);
        return res;
    }
}
