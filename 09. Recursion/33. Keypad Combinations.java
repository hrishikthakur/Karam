class Solution {

    String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res;
    
    public void letterCombinationsHelper(int currDigitIdx, String output, String input){
        if(currDigitIdx == input.length()){
            if(output.length() > 0) res.add(output);
            return;
        }
        
        char currDigit = input.charAt(currDigitIdx);
        for(Character c : keypad[currDigit - '0'].toCharArray()){
            letterCombinationsHelper(currDigitIdx + 1, output + c, input);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        letterCombinationsHelper(0, "", digits);
        return res;
    }
} 
