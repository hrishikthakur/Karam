// Items on level
class Solution {
    public static void combine(int currCoin, List<List<Integer>> res, List<Integer> combination, 
                               List<Integer>uniqueCoins, HashMap<Integer, Integer> freq, int target){
        // +ve base case
        if(target == 0){
            List<Integer> temp = new ArrayList<>(combination);
            res.add(temp);
            return;
        }
        // -ve base case
        if(currCoin == uniqueCoins.size()) return;
        
        int coin = uniqueCoins.get(currCoin);
        // how many times the coin can be used
        for(int i = 0; i <= freq.get(coin); i++){
            if(target - i * coin >= 0){
                // use the coin 
                for(int j = 1; j <= i; j++)
                    combination.add(coin);
                
                combine(currCoin + 1, res, combination, uniqueCoins, freq, target - i * coin);
                
                
                for(int j = 1; j <= i; j++)
                    combination.remove(combination.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> uniqueCoins = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < candidates.length; i++){
            int coin = candidates[i];
            if(freq.containsKey(coin) == false){
                uniqueCoins.add(coin);
                freq.put(coin, 1);
            }else{
                freq.put(coin, freq.get(coin) + 1);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        combine(0, res, new ArrayList<>(), uniqueCoins, freq, target);
        return res;
    }
}


// Box on level -> fail
class Solution {
    public static void combine(int lastIdx, List<List<Integer>> res, List<Integer> combination,
                               List<Integer> uniqueCoins, HashMap<Integer, Integer> freq, int target){
        if(target == 0){
            List<Integer> temp = new ArrayList<>(combination);
            res.add(temp);
            return;
        }
        
        for(int i = lastIdx; i < uniqueCoins.size(); i++){
            int coin = uniqueCoins.get(i);
            if(coin <= target){
                int oldFreq = freq.get(coin);
                freq.put(coin, oldFreq - 1);
                combination.add(coin);
                
                combine(lastIdx + 1, res, combination, uniqueCoins, freq, target - coin);
                
                combination.remove(combination.size() - 1);
                freq.put(coin, oldFreq);
            }
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> uniqueCoins = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < candidates.length; i++){
            int coin = candidates[i];
            if(freq.containsKey(coin) == false){
                uniqueCoins.add(coin);
                freq.put(coin, 1);
            }else{
                freq.put(coin, freq.get(coin) + 1);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        combine(0, res, combination, uniqueCoins, freq, target);
        return res;
    }
}
