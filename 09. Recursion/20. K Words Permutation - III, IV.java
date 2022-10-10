// Box on level -> IV
public class Main {

 public static void permute(int currBox, String permutation, String ustr, HashMap<Character, Integer> freq, int k){
    if(currBox == k) {
        System.out.println(permutation);
        return;
    }
    
    for(Character c : ustr.toCharArray()){
        int oldFreq = freq.get(c);
        if(oldFreq > 0){
            freq.put(c, oldFreq - 1);
            permute(currBox + 1, permutation + c, ustr, freq, k);
            freq.put(c, oldFreq);
        }
    }
 }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());
    HashMap<Character, Integer> freq = new HashMap<>();
    String ustr = "";
    for(Character c : str.toCharArray()){
        if(freq.containsKey(c) == false){
            freq.put(c, 1);
            ustr += c;
        }else{
            freq.put(c, freq.get(c) + 1);
        }
    }
    
    permute(0, "", ustr, freq, k);
  }
}
