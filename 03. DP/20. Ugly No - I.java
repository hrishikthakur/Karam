// Any Number = Prime1 ^ a + Prime2 ^ b + Prime3 ^ c
// Time - O(Root N) in Worst Case, O(log2 N + log3 N + log4N) in Average Case

class Solution {
    public boolean isUgly(int n) {
        if(n == 0) return false;
        
        while(n % 2 == 0) n /= 2;
        while(n % 3 == 0) n /= 3;
        while(n % 5 == 0) n /= 5;
        
        if(n == 1) return true;
        return false;
    }
}
