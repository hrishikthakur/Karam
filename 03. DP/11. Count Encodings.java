// Memoization -> O(n) Time, O(n) Space
class Solution {
    
    public int numDecodings(String s, int idx, int[] dp){
        if(idx == s.length()) return 1;
        
        if(dp[idx] != -1) return dp[idx];
        
        int ans1 = (s.charAt(idx) != '0') ? numDecodings(s, idx + 1, dp) : 0;
        int ans2 = 0;
        if(idx + 1 < s.length() && s.charAt(idx) != '0'){
            int code = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
            if(code >= 10 && code <= 26) {
                ans2 = numDecodings(s, idx + 2, dp);
            }
        }
        
        return dp[idx] = ans1 + ans2;
    }
    
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return numDecodings(s, 0, dp);
    }
}

// Tabulation -> O(n) Time, O(n) Space
    public static int countEncodingsTab(String str) {
        int[] dp = new int[str.length() + 1];
        dp[str.length()] = 1;

        for (int i = str.length() - 1; i >= 0; i--) {
            int ch1 = (str.charAt(i) - '0');
            if (ch1 >= 1 && ch1 <= 9) {
                dp[i] += dp[i + 1];
            }

            if (i + 1 < str.length()) {
                int ch12 = (str.charAt(i) - '0') * 10 + (str.charAt(i + 1) - '0');
                if (ch12 >= 10 && ch12 <= 26)
                    dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

    // Space Optimization (Two Pointer Technique) is Also Possible
    // Since there are limited previous states -> Do It Yourself
    // Time - O(N), Space - O(1)
