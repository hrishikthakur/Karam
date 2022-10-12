// Items on level
class Solution {
    public static void combine(int currCoin, List<List<Integer>> res, List<Integer> combination, int[] coins, int target){
        if(target == 0){
            List<Integer> temp = new ArrayList<>(combination);
            res.add(temp);
            return;
        }
        
        if(currCoin == coins.length) return;
        
        int val = coins[currCoin];
        int times_used = 0;
        while(val * times_used <= target){
            for(int i = 1; i <= times_used; i++)
                combination.add(val);
            
            combine(currCoin + 1, res, combination, coins, target - (val * times_used));
            
            for(int i = 1; i <= times_used; i++)
                combination.remove(combination.size() - 1);
            
            times_used++;
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combine(0, res, new ArrayList<>(), candidates, target);
        return res;
    }
}
