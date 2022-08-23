class Solution {
    
    public long minSteps(int screen, int buffer, long dest, long[][] dp){
        if(screen == dest) return 0; // no more steps required
        if(screen > dest) return Integer.MAX_VALUE;
        
        if(dp[screen][buffer] != -1l) return dp[screen][buffer];
        
        long copyPaste = 2l + minSteps(2 * screen, screen, dest, dp);
        long paste = 1l + minSteps(screen + buffer, buffer, dest, dp);
        
        return dp[screen][buffer] = Math.min(copyPaste, paste);
    }
    
    public int minSteps(int n) {
        if(n == 1) return 0;
        
        long[][] dp = new long[n + 1][n + 1];
        
        for(int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
        
        // 1 is to copy into the buffer and then call recursion to solve further
        return (int) (1l + minSteps(1, 1, n, dp));
    }
}  

// PRIME FACTORIZATION METHOD
class Maths {
    // Mathematics (Prime Factorization) -
    // O(Root N) Time, O(1) Space

    public int minSteps(int n) {
        int ans = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}
