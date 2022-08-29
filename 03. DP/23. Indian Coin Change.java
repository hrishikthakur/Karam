// Time - O(N), Space - O(1) Extra Space, O(N) Output Space
class Solution{
    static List<Integer> minPartition(int N)
    {
        List<Integer> res = new ArrayList<>();
        int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        for(int i = coins.length - 1; i >= 0; i--){
            while(coins[i] <= N){
                N -= coins[i];
                res.add(coins[i]);
            }
            if(N == 0) break;
        }
        
        return res;
    }
}

// For Counting the Minimum Coins, Time will be O(Coins) = O(10) = O(1)
class Solution{
  static int minCoins(int target) {
      int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
      int count = 0;
      for (int i = coins.length - 1; i >= 0; i--) {
          count = count + (target * (target / coins[i]));
          target -= (target / coins[i]);
          if (target == 0)
              break;
      }
      return count;
  }
}
