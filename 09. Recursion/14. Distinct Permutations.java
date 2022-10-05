class Solution {
    public void permuteUnique(List<List<Integer>> permutations, List<Integer> permutation, 
                              HashMap<Integer, Integer> freq, int currBox, int totalBoxes){
        
        if(currBox == totalBoxes){
            List<Integer> temp = new ArrayList<>(permutation);
            permutations.add(temp);
            return;
        }
        
        for(Integer key : freq.keySet()){
            int val = freq.get(key);
            if(val > 0){
                freq.put(key, val - 1);
                permutation.add(key);
                permuteUnique(permutations, permutation, freq, currBox + 1, totalBoxes);
                permutation.remove(currBox);
                freq.put(key, val);
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        permuteUnique(permutations, permutation, freq, 0, nums.length);
        return permutations;
    }
}
