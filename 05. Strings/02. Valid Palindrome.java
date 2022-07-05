class Solution {
    public boolean isPalindrome(String s) {
        
        String str = s.toLowerCase();
    
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
                // Character.isLetter(ch) || Character.isDigit(ch)
                sb.append(ch);
            }
        }
        
        int l = 0, r = sb.length() - 1;
        while(l < r){
            if(sb.charAt(l) != sb.charAt(r)) return false;
            l++;
            r--;
        }
        
        return true;
    }
}
