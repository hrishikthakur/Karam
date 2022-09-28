class Solution {
    
    public boolean isAnagram(int[] arr1, int[] arr2){
        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        
        int K = s1.length();
        
        int[] target_freq = new int[26];
        for(int i = 0; i < s1.length(); i++){
            target_freq[s1.charAt(i) - 'a']++;
        }
        
        int[] curr_freq = new int[26];
        for(int i = 0; i < K; i++){
            curr_freq[s2.charAt(i) - 'a']++;
        }
        if(isAnagram(target_freq, curr_freq)) return true;
        
        for(int i = K; i < s2.length(); i++){
            curr_freq[s2.charAt(i - K) - 'a']--;
            curr_freq[s2.charAt(i) - 'a']++;
            
            if(isAnagram(target_freq, curr_freq)) return true;
        }
        
        return false;
    }
}
