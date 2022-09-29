// Time:O(2N), Space:O(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max_len = 0, left = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            char inc = s.charAt(right);
            freq.put(inc, freq.getOrDefault(inc, 0) + 1);
            while(freq.get(inc) > 1){
                char exc = s.charAt(left);
                if(freq.get(exc) == 1) freq.remove(exc);
                else freq.put(exc, freq.get(exc) - 1);
                left++;
            }
            max_len = Math.max(max_len, freq.size());
        }
        return max_len;
    }
}
