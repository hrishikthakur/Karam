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

// Without using permutation<Integer>, visited[]
class Solution {
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void permute(List<List<Integer>> permutations, int[] nums, int currBox){
        if(currBox == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < nums.length; i++)
                temp.add(nums[i]);
            permutations.add(temp);
            return;
        }
        for(int i = currBox; i < nums.length; i++){
            swap(nums, currBox, i);
            permute(permutations, nums, currBox + 1);
            swap(nums, currBox, i);
        }   
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permute(permutations, nums, 0);
        return permutations;
    }
}
