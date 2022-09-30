// Time:O(26N), Space:O(1)
class Solution {
    public int helper(String s, int k, char target){
        int max_len = 0, replacements = 0, left = 0;
        for(int right = 0; right < s.length(); right++){
            if(s.charAt(right) != target) replacements++;

            while(replacements > k){
                if(s.charAt(left) != target) replacements--;
                left++;
            }
            max_len = Math.max(max_len, right - left + 1);
        }
        return max_len;
    }
    
    public int characterReplacement(String s, int k) {
        int max_len = 0;
        for(int i = 0; i < 26; i++){
            max_len = Math.max(max_len, helper(s, k, (char)(i + 'A')));
        }
        return max_len;
    }
}
