class Solution {
    public void permute(List<List<Integer>> permutations, List<Integer> permutation, boolean[] itemPlaced, int[] nums, int currBox){
        if(currBox == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(Integer i : permutation)
                temp.add(i);
            permutations.add(temp);
        }
        
        for(int i = 0; i < nums.length; i++){
            if(itemPlaced[i] == false){
                itemPlaced[i] = true;
                permutation.add(nums[i]);
                permute(permutations, permutation, itemPlaced, nums, currBox + 1);
                permutation.remove(permutation.size() - 1);
                itemPlaced[i] = false;
            }
        }
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] itemPlaced = new boolean[nums.length];
        permute(permutations, permutation, itemPlaced, nums, 0);
        return permutations;
    }
}
