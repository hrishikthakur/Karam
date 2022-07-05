class Solution{
    public String removeConsecutiveCharacter(String S){
        
        char[] str = S.toCharArray();
        StringBuilder res = new StringBuilder();
        res.append(str[0]);
        for(int i = 1; i < str.length; i++){
            if(str[i] != str[i - 1]) res.append(str[i]);    
        }
        
        return new String(res);
    }
}
