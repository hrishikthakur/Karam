class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> pattern = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            pattern.put(ch, pattern.getOrDefault(ch, 0) + 1);
        }
        
        int count_matching = 0, min_len = Integer.MAX_VALUE, left = 0, start = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for(int right = 0; right < s.length(); right++){
            char inc = s.charAt(right);
            freq.put(inc, freq.getOrDefault(inc, 0) + 1);
            if(pattern.getOrDefault(inc, 0).equals(freq.get(inc))) count_matching++;
            
            while(count_matching == pattern.size()){
                if(right - left + 1 < min_len){
                    start = left;
                    min_len = right - left + 1;
                }
                
                char exc = s.charAt(left);
                if(freq.get(exc) == 1) freq.remove(exc);
                else freq.put(exc, freq.get(exc) - 1);
                
                if(pattern.containsKey(exc) && freq.getOrDefault(exc, 0) < pattern.get(exc)){
                    count_matching--;
                }
                left++;
            }
        }
        return (min_len == Integer.MAX_VALUE) ? "" : s.substring(start, start + min_len);
    }
}
