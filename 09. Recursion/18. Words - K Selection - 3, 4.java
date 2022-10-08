// Items on level
// ALL occurances of a unique item on level
public class Main {

  public static void combine(int currChar, String combination, HashMap<Character, Integer> freq, String uniques, int k){
      if(combination.length() == k){
          System.out.println(combination);
          return;
      }
      
      // -ve base case
      if(currChar == uniques.length()){
          return;
      }
      
      int freq_curr_char = freq.get(uniques.charAt(currChar));
      // reverse loop because the output demands the 1st call to be made for 
      // all available a's and so on
      // i == 0 is for no ki call
      for(int i = freq_curr_char; i >= 0; i--){
          if(combination.length() + i > k) continue;
          
          String newRes = combination;
          for(int j = 1; j <= i; j++)
            newRes += uniques.charAt(currChar);
        
          combine(currChar + 1, newRes, freq, uniques, k);
      }
  }

  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());
    
    HashMap<Character, Integer> freq = new HashMap<>(); // kitni baar loop chalani hai
    String uniques = ""; // kis order me char explore karne hai
    for(int i =0; i < str.length(); i++){
        char c = str.charAt(i);
        if(freq.containsKey(c) == false){
            uniques += c;
            freq.put(c, 1);
        }else{
            freq.put(c, freq.get(c) + 1);
        }
    }
    
    combine(0, "", freq, uniques, k);
  }
}

// Box on level
public class Main {

  public static void combine(int currBox, int lastIdx, String combination, String uniques, 
  HashMap<Character, Integer> freq, int k){
    if(currBox == k){
        System.out.println(combination);
        return;
    }
    
    if(lastIdx == uniques.length()) return;
    
    for(int i = lastIdx; i < uniques.length(); i++){
        char c = uniques.charAt(i);
        if(freq.get(c) > 0){
            freq.put(c, freq.get(c) - 1);
            combine(currBox + 1, i, combination + c, uniques, freq, k);
            freq.put(c, freq.get(c) + 1);
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());
    
    HashMap<Character, Integer> freq = new HashMap<>();
    String uniques = "";
    for(int i = 0; i < str.length(); i++){
        char c = str.charAt(i);
        if(freq.containsKey(c) == false){
            uniques += c;
            freq.put(c, 1);
        }else{
            freq.put(c, freq.get(c) + 1);
        }
    }
    
    combine(0, 0, "", uniques, freq, k);
  }
}
