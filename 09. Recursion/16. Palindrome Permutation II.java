public class Solution {
    public static void generatePalindromes(List<String> permutations, StringBuilder permutation, int currBox, HashMap<Character, Integer> freq){
        if(currBox == permutation.length() / 2){
            permutations.add(new String(permutation));
            return;
        }

        for(Character c : freq.keySet()){
            if(freq.get(c) > 0){
                permutation.setCharAt(currBox, c);
                permutation.setCharAt(permutation.length() - 1 - currBox, c);
                freq.put(c, freq.get(c) - 2);

                generatePalindromes(permutations, permutation, currBox + 1, freq);

                permutation.setCharAt(currBox, '0');
                permutation.setCharAt(permutation.length() - 1 - currBox, '0');
                freq.put(c, freq.get(c) + 2);
            }
        }
    }

    public List<String> generatePalindromes(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        char odd_freq_char = '0';
        for(Character c : freq.keySet()){
            if(freq.get(c) % 2 == 1) {
                if(odd_freq_char != '0') return new ArrayList<>();
                odd_freq_char = c;
            }
        }

        int totalBoxes = s.length();
        StringBuilder permutation = new StringBuilder("");
        for(int i = 0; i < totalBoxes; i++)
            permutation.append('0');
        
        if(totalBoxes % 2 == 1) {
            permutation.setCharAt(totalBoxes / 2, odd_freq_char);
            freq.put(odd_freq_char, freq.get(odd_freq_char) - 1);
        }

        List<String> permutations = new ArrayList<>();
        generatePalindromes(permutations, permutation, 0, freq);
        return permutations;
    }
}
