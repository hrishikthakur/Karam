class Solution 
{ 
    String printSequence(String S) 
    { 
        String[] num_val = {"2","22","222",
                        "3","33","333",
                        "4","44","444",
                        "5","55","555",
                        "6","66","666",
                        "7","77","777","7777",
                        "8","88","888",
                        "9","99","999","9999"
                        };
        
        // StringBuilder sb = new StringBuilder();
        String res = "";
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            if(ch == ' '){
                // sb.append('0');
                res = res + '0';
            }
            else{
                // sb.append(num_val[ch  - 'A']);   
                res = res + num_val[ch - 'A'];
            }
        }
        
        // return new String(sb);
        return res;
    }
}

// Objects of string are immutable, "References" are not.
