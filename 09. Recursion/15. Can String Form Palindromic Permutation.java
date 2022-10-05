public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        
        int count_odd_freq = 0;
        for(Character key : freq.keySet()){
            if(freq.get(key) % 2 == 1){
                count_odd_freq++;
            }
        }
        return (count_odd_freq > 1) ? false : true;
    }
}
