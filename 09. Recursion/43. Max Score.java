class Solution {
    
    public int helper(int idx, String[] words, int[] score, int[] freq){
        if(idx == words.length) return 0;
        
        int wordScore = 0;
        boolean flag = true; // if given freq of chars < freq of chars to form currWord
        for(Character ch : words[idx].toCharArray()){
            wordScore += score[ch - 'a'];
            freq[ch - 'a'] -= 1;
            
            if(freq[ch - 'a'] < 0) flag = false;
        }
        
        int maxScore = 0;
        if(flag) maxScore = wordScore + helper(idx + 1, words, score, freq); // yes
        // backtrack
        for(Character ch : words[idx].toCharArray())
            freq[ch - 'a'] += 1;
        
        return Math.max(maxScore, helper(idx + 1, words, score, freq)); // Max(yes, no)
    }
    
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for(Character ch : letters)
            freq[ch - 'a'] += 1;
        
        return helper(0, words, score, freq);
    }
}
