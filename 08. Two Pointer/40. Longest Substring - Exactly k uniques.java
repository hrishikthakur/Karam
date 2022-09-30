// Time:O(2N), Space:O(N)
class Solution {
    public int longestkSubstr(String s, int k) {
        
        HashMap<Character, Integer> freq = new HashMap<>();
        int max_len = Integer.MIN_VALUE, left = 0;
        
        for(int right = 0; right < s.length(); right++){
            char inc = s.charAt(right);
            freq.put(inc, freq.getOrDefault(inc, 0) + 1);
            
            if(freq.size() == k) max_len = Math.max(max_len, right - left + 1);
            
            while(freq.size() > k){
                char exc = s.charAt(left);
                if(freq.get(exc) == 1) freq.remove(exc);
                else freq.put(exc, freq.get(exc) - 1);
                left++;
            }
        }
        return (max_len == Integer.MIN_VALUE) ? -1 : max_len;
    }
}
