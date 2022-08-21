// Memoization -> O(N) Time, O(N) Space
class Solution{
    
    public int countMin(int N, int[] dp){
        if(N == 1) return 0;
        
        if(dp[N] != -1) return dp[N];
        int a = (N % 2 == 0) ? countMin(N/2, dp) : Integer.MAX_VALUE;
        int b = (N % 3 == 0) ? countMin(N/3, dp) : Integer.MAX_VALUE;
        int c = countMin(N-1, dp);
        
        dp[N] = Math.min(a, Math.min(b, c)) + 1;
        return dp[N];
    }
 
	public int minSteps(int N) 
	{ 
	    int[] dp = new int[N + 1];
	    Arrays.fill(dp, -1);
	    return countMin(N, dp);
	} 
}
