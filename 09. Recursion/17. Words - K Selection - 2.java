// Time:O(N!) or Exponential
public class Main {
  public static void combine(String permutation, List<Character> uniques, int k, int lastIdx){
      if(permutation.length() == k){
          System.out.println(permutation);
          return;
      }
      
      for(int i = lastIdx + 1; i < uniques.size(); i++){
          combine(permutation + uniques.get(i), uniques, k, i);
      }
  }  

  public static void main(String[] args){
      Scanner scn = new Scanner(System.in);
      String s = scn.nextLine();
      int k = scn.nextInt();
      
      HashSet<Character> unique = new HashSet<>(); // to get unique characters
      List<Character> uniques = new ArrayList<>(); // to get unique characters as they appear in the string
      for(int i = 0; i < s.length(); i++){
          char c = s.charAt(i);
          if(unique.contains(c) == false) uniques.add(c);
          unique.add(c);
      }
      
      combine("", uniques, k, -1);
  }

}
