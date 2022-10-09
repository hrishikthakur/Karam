// Box on Level -> Permutation - II
public class Main {

 public static void permute(String permutation, HashSet<Character> unique, String uniques, int k){
    if(permutation.length() == k){
        System.out.println(permutation);
        return;
    }
    
    for(char c : uniques.toCharArray()){
        if(unique.contains(c) == true){
            unique.remove(c);
            permute(permutation + c, unique, uniques, k);
            unique.add(c);
        }
    }
 }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String uniques = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        uniques += ch;
      }
    }
    permute("", unique, uniques, k);
  }
}
